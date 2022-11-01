package uppercaseRMI_MVVM.server.networking;

import uppercaseRMI_MVVM.server.model.TextManager;
import uppercaseRMI_MVVM.shared.networking.CLientCallBack;
import uppercaseRMI_MVVM.shared.networking.RMIServer;
import uppercaseRMI_MVVM.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIServerImpl implements RMIServer
{

  private final TextManager textManager;

  public RMIServerImpl(TextManager textManager) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this,0);
    this.textManager=textManager;
  }


  public void startServer() throws RemoteException, AlreadyBoundException
  {
    Registry registry=LocateRegistry.createRegistry(1099);
    registry.bind("UppercaseServer",this);

  }

  @Override public String toUppercase(String str)
  {
    return textManager.toUppercase(str);
  }

  @Override public List<LogEntry> getLogs()
  {
    return textManager.getLog();
  }

  @Override public void registerClient(CLientCallBack cLient)
  {
   PropertyChangeListener listener=null;
  // PropertyChangeListener finalListener = listener;
       listener= evt -> {
      try
      {
        cLient.update((LogEntry) evt.getNewValue());
      }
      catch (RemoteException e)
      {
        //textManager.removeListener("NewLogEntry",finalListener);
      }
    };
    textManager.addListener("NewLogEntry",listener);
  }
}
