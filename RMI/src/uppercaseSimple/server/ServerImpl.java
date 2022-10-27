package uppercaseSimple.server;


import uppercaseSimple.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements UpperCaseServer
{

    public ServerImpl(){
        try {
            UnicastRemoteObject.exportObject(this, 1099);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toUpperCase(String arg) {
        return arg.toUpperCase();
    }
}
