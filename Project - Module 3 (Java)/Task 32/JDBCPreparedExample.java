import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class StudentDAO {
    private String url = "jdbc:mysql://localhost:3306/world";
    private String user = "root";
    private String password = "cvr123";

    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, password);
    }

    public void insertStudent(int id, String name) {
        String query = "INSERT INTO students (id, name) VALUES (?, ?)";
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            System.out.println("Student Inserted Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudentName(int id, String newName) {
        String query = "UPDATE students SET name = ? WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, newName);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Student Updated Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class JDBCPreparedExample {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        dao.insertStudent(101, "Vikram");
        dao.updateStudentName(101, "Vikram Kumar");
    }
}