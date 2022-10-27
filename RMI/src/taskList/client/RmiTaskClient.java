package taskList.client;

import taskList.shared.RemoteTaskList;
import uppercaseSimple.shared.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiTaskClient
{
  private RemoteTaskList remoteTaskList;

  public RmiTaskClient()
  {

  }

  public void startClient(String host){

    Registry registry = null;
    try
    {
      registry = LocateRegistry.getRegistry(host, 1111);
      remoteTaskList = (RemoteTaskList) registry.lookup("Server");
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }

  }
}
