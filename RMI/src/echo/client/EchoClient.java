package echo.client;

import echo.shared.RemoteEchoServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class EchoClient
{
  private RemoteEchoServer remoteEchoServer;

  public EchoClient()
  {

  }

  public void startClient(){
    try
    {
      Registry registry= LocateRegistry.getRegistry("localhost",2000);
      remoteEchoServer= (RemoteEchoServer)registry.lookup("server");
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  public String addMessage(String msg){
    try
    {
      remoteEchoServer.toUpperCase(msg);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return msg;
  }
}
