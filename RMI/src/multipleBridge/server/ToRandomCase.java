package multipleBridge.server;

import multipleBridge.shared.IToRandomCase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ToRandomCase implements IToRandomCase
{
  public ToRandomCase()
  {
    try
    {
      UnicastRemoteObject.exportObject(this,9000);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public String toRandomCase(String arg) throws RemoteException
  {
    String result="";
    char[] chars=arg.toCharArray();
    for (int i = 0; i < chars.length; i++)
    {
      result += Math.random()< 0.5 ?(chars[i] +"").toUpperCase():(chars[i]+"").toLowerCase();
    }
    return result;
  }
}
