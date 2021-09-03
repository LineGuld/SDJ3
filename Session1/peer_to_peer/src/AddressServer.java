import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddressServer extends Remote
{
  void registerPeer() throws RemoteException;
  int findPeer() throws RemoteException;
}
