package printingMessage;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client
{

  private TextServer server;

  public Client()
  {

  }

  public void runClient()
  {
    try
    {
      Registry registry = LocateRegistry.getRegistry("localHost",2222);
      server = (TextServer) registry.lookup("server");
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }

  }

  public void sendText(String text)
  {
    try
    {
      server.printText(text);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }

  }


}
