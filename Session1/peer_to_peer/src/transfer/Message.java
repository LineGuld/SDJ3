package transfer;

public class Message
{
  private String message;
  private int senderId;
  private int receiverId;

  public Message(String message, int senderId, int receiverId)
  {
    this.message = message;
    this.senderId = senderId;
    this.receiverId = receiverId;
  }

  public String getMessage()
  {
    return message;
  }

  public int getSenderId()
  {
    return senderId;
  }

  public int getReceiverId()
  {
    return receiverId;
  }


}
