package echo.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    System.out.println("Server up");
    RemoteEchoServerImpl server= new RemoteEchoServerImpl();
    Registry registry= LocateRegistry.createRegistry(2000);
    registry.bind("server",server);
  }
}
