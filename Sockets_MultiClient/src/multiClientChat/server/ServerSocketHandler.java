package multiClientChat.server;

import multiClientChat.shared.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectInputStream objectInputStream;
  private ObjectOutputStream objectOutputStream;
  private ConnectionPool pool;
  private String userName;

  public ServerSocketHandler(Socket socket,ConnectionPool pool)
  {
    this.socket = socket;
    this.pool=pool;
    try
    {
      objectInputStream= new ObjectInputStream(socket.getInputStream());
      objectOutputStream= new ObjectOutputStream(socket.getOutputStream());

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
      userName= (String) objectInputStream.readObject();
      while (true){
        Message message = (Message) objectInputStream.readObject();

        String body= message.getMessage();
        System.out.println(message);
        if (body.equalsIgnoreCase("exit")){
          socket.close();
          break;
        }
        pool.broadCast(message);
      }
    }
    catch (Exception e){
      e.printStackTrace();
    }

  }

  public void sendMessage(Message message) throws IOException
  {
    objectOutputStream.writeObject(message);
  }

  public String getClientName()
  {
    return userName;
  }
}
