package multipleBridge.client;

import multipleBridge.server.ToRandomCase;
import multipleBridge.server.ToUpperCase;
import multipleBridge.shared.IStringChangingServer;
import multipleBridge.shared.IToRandomCase;
import multipleBridge.shared.IToUpperCase;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteClient
{
  private IStringChangingServer server;
  public RemoteClient()
  {

  }

  public void strartClient(){

    Registry registry = null;
    try
    {
      registry = LocateRegistry.getRegistry("localhost", 4000);
      server = (IStringChangingServer) registry.lookup("server");
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }


  }

  public  String changeToUppercase(String arg){
    String result="";
    IToUpperCase upperCase= new ToUpperCase();
    try
    {
      result=upperCase.toUpperCase(arg);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return result;
  }

  public String changeToRandomcase(String arg){
    String result="";
    IToRandomCase randomCase= new ToRandomCase();
    try
    {
      result=randomCase.toRandomCase(arg);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return result;
  }

}
