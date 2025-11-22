import java.io.*;
import java.net.*;

public class ChatClient {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5000);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        System.out.println("Connected to chat. Start typing...");

        new Thread(() -> {
            try {
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("\n" + msg);
                }
            } catch (Exception e) {
                System.out.println("Disconnected from chat.");
            }
        }).start();

        String message;
        while ((message = keyboard.readLine()) != null) {
            out.println(message);
        }
    }
}
