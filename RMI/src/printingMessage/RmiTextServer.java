package printingMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiTextServer implements TextServer
{
  public RmiTextServer()
  {
    try
    {
      UnicastRemoteObject.exportObject(this,2222);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void printText(String Text) throws RemoteException
  {
    System.out.println(Text);
  }
}
