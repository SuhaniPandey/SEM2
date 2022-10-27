package multipleBridge.server;

import multipleBridge.shared.IToUpperCase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ToUpperCase implements IToUpperCase
{
  public ToUpperCase()
  {
    try
    {
      UnicastRemoteObject.exportObject(this,8000);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public String toUpperCase(String arg) throws RemoteException
  {
    return arg.toUpperCase();
  }


}
