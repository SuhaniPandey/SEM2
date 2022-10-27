package echo.server;

import echo.shared.RemoteEchoServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteEchoServerImpl implements RemoteEchoServer
{
  public RemoteEchoServerImpl(){
    try
    {
      UnicastRemoteObject.exportObject(this,2000);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public String toUpperCase(String msg) throws RemoteException
  {
    return msg.toUpperCase();
  }
}
