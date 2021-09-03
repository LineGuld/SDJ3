import java.rmi.RemoteException;
import java.util.HashMap;

public class AddressServerImpl implements AddressServer
{

  private HashMap registry;

  @Override public void registerPeer() throws RemoteException
  {

  }

  @Override public int findPeer() throws RemoteException
  {
    return 0;
  }
}
