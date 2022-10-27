package uppercaseRMI_MVVM.shared.networking;

import uppercaseRMI_MVVM.shared.transferobjects.LogEntry;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CLientCallBack extends Remote
{
  void update(LogEntry log) throws RemoteException;
}
