package chatClientExample.server;

import chatClientExample.shared.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectInputStream inputStream;
  private ObjectOutputStream outputStream;
  private ConnectionPool connectionPool;
  private String username;

  public ServerSocketHandler(Socket socket, ConnectionPool connectionPool)
  {
    this.socket = socket;
    this.connectionPool=connectionPool;
    try
    {
      inputStream= new ObjectInputStream(socket.getInputStream());
      outputStream= new ObjectOutputStream(socket.getOutputStream());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {
    try
    {
      username=(String) inputStream.readObject();
      while (true)
      {
        Message message = (Message) inputStream.readObject();

        String body = message.getMessageBody();
        System.out.println(message);

        if (body.equalsIgnoreCase("exit"))
        {
          connectionPool.removeConnection(this);
          outputStream.writeObject(message);
          socket.close();
          break;
        }
        connectionPool.broadcast(message);
      }
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public void sendMessageToClient(Message msg)
  {
    try
    {
      outputStream.writeObject(msg);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public String getClientName()
  {
    return username;
  }
}
