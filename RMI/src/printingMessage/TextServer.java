package printingMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TextServer extends Remote
{
  void printText(String Text) throws RemoteException;
}
