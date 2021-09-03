import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class AddressServerImpl implements AddressServer
{

  private static HashMap<String, Integer> peerRegistry;

  private AddressServerImpl()
  {
    try
    {
      UnicastRemoteObject.exportObject(this, 1099);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    this.peerRegistry = new HashMap<>();
  }

  public static HashMap<String, Integer> getInstance()
  {
    if (peerRegistry == null)
    {
      peerRegistry = new HashMap<>();
    }
    return peerRegistry;
  }

  public void startServer()
  {
    Registry registry = null;
    try
    {
      registry = LocateRegistry.createRegistry(1099);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    try
    {
      registry.bind("addressServer", this);
    }
    catch (RemoteException | AlreadyBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void registerPeer(String name, int id) throws RemoteException
  {
    peerRegistry.put(name, id);
  }

  @Override public int findPeer(String name) throws RemoteException
  {
    return peerRegistry.get(name);
  }
}
