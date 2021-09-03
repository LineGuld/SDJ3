package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddressServer extends Remote
{
  void registerPeer(String name, int id) throws RemoteException;
  int findPeer(String name) throws RemoteException;
}
