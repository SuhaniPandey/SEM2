package multipleBridge.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStringChangingServer extends Remote
{
  IToUpperCase getUppercaser() throws RemoteException;
  IToRandomCase getRandomCase() throws RemoteException;
}
