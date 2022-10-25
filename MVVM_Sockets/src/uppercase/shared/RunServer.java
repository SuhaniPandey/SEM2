package uppercase.shared;

import uppercase.server.model.TextManagerImpl;
import uppercase.server.networking.SocketServer;

public class RunServer {
    public static void main(String[] args) {

        SocketServer ss = new SocketServer(new TextManagerImpl());
        ss.startServer();
    }
}
