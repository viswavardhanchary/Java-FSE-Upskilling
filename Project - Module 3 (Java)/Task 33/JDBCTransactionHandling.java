import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCTransactionHandling {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/world";
        String user = "root";
        String password = "cvr123";

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false);

            String debitQuery = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            PreparedStatement debitStmt = con.prepareStatement(debitQuery);
            debitStmt.setDouble(1, 5000.0);
            debitStmt.setInt(2, 112233);
            debitStmt.executeUpdate();

            String creditQuery = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
            PreparedStatement creditStmt = con.prepareStatement(creditQuery);
            creditStmt.setDouble(1, 5000.0);
            creditStmt.setInt(2, 445566);
            creditStmt.executeUpdate();

            con.commit();
            System.out.println("Transaction Committed Successfully");

        } catch (Exception e) {
            System.out.println("Transaction Failed. Rolling Back...");
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}