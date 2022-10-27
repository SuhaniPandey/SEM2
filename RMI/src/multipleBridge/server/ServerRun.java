package multipleBridge.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRun
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    System.out.println("server runs...");
    Registry registry= LocateRegistry.createRegistry(4000);
    StringChangingServer server= new StringChangingServer();
    registry.bind("server",server);
  }
}
