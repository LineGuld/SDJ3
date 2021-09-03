import java.rmi.RemoteException;
import java.util.HashMap;

public class AddressServerImpl implements AddressServer
{

  private static HashMap<String, Integer> registry;

  private AddressServerImpl()
  {
    this.registry = new HashMap<>();
  }

  public static HashMap<String, Integer> getInstance(){
    if (registry == null)
    {
      registry = new HashMap<>();
    }
    return registry;
  }

  @Override public void registerPeer(String name, int id) throws RemoteException
  {
      registry.put(name, id);
  }

  @Override public int findPeer(String name) throws RemoteException
  {
    return registry.get(name);
  }
}
