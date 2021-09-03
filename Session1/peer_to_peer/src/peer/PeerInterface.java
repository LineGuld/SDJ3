package peer;

import transfer.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PeerInterface extends Remote
{
  void deliverMessage() throws RemoteException;
  void receiveMessage(Message message) throws RemoteException;
}
