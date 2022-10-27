package multipleBridge.server;

import multipleBridge.shared.IStringChangingServer;
import multipleBridge.shared.IToRandomCase;
import multipleBridge.shared.IToUpperCase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringChangingServer implements IStringChangingServer
{
  public StringChangingServer()
  {
    try
    {
      UnicastRemoteObject.exportObject(this,4000);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public IToUpperCase getUppercaser() throws RemoteException
  {
    IToUpperCase iToUpperCase= new ToUpperCase();
    return iToUpperCase;
  }

  @Override public IToRandomCase getRandomCase() throws RemoteException
  {
    IToRandomCase iToRandomCase= new ToRandomCase();
    return iToRandomCase;
  }
}
