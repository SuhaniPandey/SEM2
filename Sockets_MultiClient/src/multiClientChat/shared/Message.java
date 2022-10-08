package multiClientChat.shared;

import java.io.Serializable;

public class Message implements Serializable
{

  private String message;
  private String user;

  public Message(String message,String user)
  {
    this.message = message;
    this.user=user;
  }

  public String getMessage()
  {
    return message;
  }

  public String getUser()
  {
    return user;
  }

  @Override public String toString()
  {
    return user+":"+ message;
  }
}
