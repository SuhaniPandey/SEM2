package printingMessage;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    RmiTextServer rmiTextServer= new RmiTextServer();
    Registry registry= LocateRegistry.createRegistry(2222);
    registry.bind("server",rmiTextServer);
  }
}
