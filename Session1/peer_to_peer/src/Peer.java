import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Peer
{
  private String name;
  private int id;
  private AddressServer server;

  public void startPeer() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (AddressServer) registry.lookup("addressServer");

    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();

    int id = (int) System.currentTimeMillis()/1000000;

    server.registerPeer(name, id);
  }
}
