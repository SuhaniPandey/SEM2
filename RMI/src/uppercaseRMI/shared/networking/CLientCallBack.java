package uppercaseRMI.shared.networking;

import uppercaseRMI.shared.transferobjects.LogEntry;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CLientCallBack extends Remote
{
  void update(LogEntry log) throws RemoteException;
}
