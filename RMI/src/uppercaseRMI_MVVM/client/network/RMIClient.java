package uppercaseRMI_MVVM.client.network;

import uppercaseRMI_MVVM.shared.networking.CLientCallBack;
import uppercaseRMI_MVVM.shared.networking.RMIServer;
import uppercaseRMI_MVVM.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIClient implements Client, CLientCallBack
{
  private RMIServer server;
  private PropertyChangeSupport support;

  public RMIClient()
  {
    support= new PropertyChangeSupport(this);
  }
  @Override public void startClient()
  {try
  {
    UnicastRemoteObject.exportObject(this,0);
    Registry registry=LocateRegistry.getRegistry("localHost",1099);
    server = (RMIServer) registry.lookup("UppercaseServer");
    server.registerClient(this);
  }
  catch (RemoteException | NotBoundException e)
  {
    e.printStackTrace();
  }

  }

  @Override public String toUppercase(String str)
  {
    try
    {
      return server.toUppercase(str);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }return null;
  }

  @Override public List<LogEntry> getLog()
  {
    try
    {
      return server.getLogs();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return null;
  }



  @Override public void update(LogEntry log) throws RemoteException
  {
    support.firePropertyChange("NewLogEntry",null,log);
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}
