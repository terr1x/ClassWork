package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server {
    private static final int PORT = 34522;
    public static ArrayList<Session> sessions=new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            for (int i = 0; i < 2; i++) {
                Session session = new Session(server.accept());
                session.start(); // it does not block this thread
                sessions.add(session);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

