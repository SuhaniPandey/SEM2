package uppercaseRMI.server;

import uppercaseRMI.server.model.TextManagerImpl;
import uppercaseRMI.server.networking.RMIServerImpl;
import uppercaseRMI.shared.networking.RMIServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args)
        throws RemoteException, AlreadyBoundException
    {

        RMIServerImpl ss = new RMIServerImpl(new TextManagerImpl());
        ss.startServer();
    }
}
