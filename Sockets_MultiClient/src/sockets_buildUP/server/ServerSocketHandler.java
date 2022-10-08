package sockets_buildUP.server;

import sockets_buildUP.utill.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectInputStream inFromClient;
  private ObjectOutputStream outToCLient;
  private ConnectionPool connectionPool;

  public ServerSocketHandler(Socket socket,ConnectionPool connectionPool) throws IOException
  {
    inFromClient = new ObjectInputStream(socket.getInputStream());
    outToCLient = new ObjectOutputStream(socket.getOutputStream());
    this.socket = socket;
    this.connectionPool=connectionPool;
  }

  @Override public void run()
  {
    try
    {

      while (true)
      {
        Message read = (Message) inFromClient.readObject();
        System.out.println("Received from client: "+read);
        if (read.getMessageBody().equalsIgnoreCase("exit")){
          socket.close();
          connectionPool.removeClient(this);
          System.out.println("Client disconnected");
          break;
        }
        String result = read.getMessageBody().toUpperCase();
        Message m = new Message(result);
        connectionPool.broadCast(m);
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }

  }

  public void sendMessage(Message message)
  {
    try
    {
      outToCLient.writeObject(message);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
