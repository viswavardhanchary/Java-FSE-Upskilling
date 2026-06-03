import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server is running on port 5000...");
            
            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in))) {
                
                System.out.println("Client connected!");
                String clientMessage, serverMessage;
                
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Client: " + clientMessage);
                    if (clientMessage.equalsIgnoreCase("exit")) break;
                    
                    System.out.print("Server: ");
                    serverMessage = serverInput.readLine();
                    out.println(serverMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}