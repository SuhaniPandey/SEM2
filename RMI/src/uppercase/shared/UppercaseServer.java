package uppercase.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UppercaseServer extends Remote
{
  String toUpperCase(String arg) throws RemoteException;

}
