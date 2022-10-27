package uppercaseRMI_MVVM.server;

import uppercaseRMI_MVVM.server.model.TextManagerImpl;
import uppercaseRMI_MVVM.server.networking.RMIServerImpl;

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
