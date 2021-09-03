package peer;

import server.AddressServer;
import transfer.Message;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Peer implements PeerInterface
{
  private String name;
  private int id;
  private AddressServer server;

  public void startPeer()
      throws RemoteException, NotBoundException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (AddressServer) registry.lookup("addressServer");

    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();

    int id = (int) System.currentTimeMillis()/1000000;

    server.registerPeer(name, id);
    Registry peerRegistry = LocateRegistry.createRegistry(1199);
    peerRegistry.bind(name+id, this);
  }


  public String getName()
  {
    return name;
  }

  public int getId()
  {
    return id;
  }

  @Override public void deliverMessage() throws RemoteException
  {

  }

  @Override public void receiveMessage(Message message) throws RemoteException
  {

  }
}
