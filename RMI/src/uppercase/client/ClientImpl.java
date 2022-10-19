package uppercase.client;

import uppercase.shared.UppercaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientImpl
{

  private UppercaseServer server;
  public ClientImpl()
  {
  }

  public void initializaConnection(){
    try
    {
      Registry registry= LocateRegistry.getRegistry("localhost",1099);
      server=(UppercaseServer) registry.lookup("Server");
    } catch (RemoteException | NotBoundException e) {
      e.printStackTrace();
    }
  }

  public String toUpperCase(String arg){
    String result=null;
    try
    {
     result = server.toUpperCase(arg);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return result;
  }
}
