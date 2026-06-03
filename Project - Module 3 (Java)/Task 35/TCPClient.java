import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in))) {
            
            System.out.println("Connected to the server. Start chatting!");
            String clientMessage, serverMessage;
            
            while (true) {
                System.out.print("Client: ");
                clientMessage = clientInput.readLine();
                out.println(clientMessage);
                if (clientMessage.equalsIgnoreCase("exit")) break;
                
                serverMessage = in.readLine();
                System.out.println("Server: " + serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}