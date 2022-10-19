package callBack.server;

import callBack.shared.UpperCaseClient;
import callBack.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements UpperCaseServer
{

    public ServerImpl(){
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void toUpperCase(String arg, UpperCaseClient client) {
        String result =  arg.toUpperCase();
        //heavy stuff
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            client.upperCaseResult(result);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
