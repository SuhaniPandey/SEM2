package taskList.server;

import uppercaseSimple.server.ServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer
{
  public static void main(String[] args)
  {
    System.out.println("Server up");
    ServerImpl server = new ServerImpl();
    Registry registry = null;
    try
    {
      registry = LocateRegistry.createRegistry(1111);
      registry.bind("Server", server);
    }
    catch (RemoteException | AlreadyBoundException e)
    {
      e.printStackTrace();
    }

  }
}
