package server.networking;

import server.model.Login;
import shared.User;
import shared.util.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerHandler implements Runnable
{
  private Socket  socket;
  private Login login;
  private User user;
  private ObjectOutputStream outputStream;
  private ObjectInputStream inputStream;

  public ServerHandler(Socket socket,Login login){
    this.socket=socket;
    this.login=login;

    try
    {
      outputStream= new ObjectOutputStream(socket.getOutputStream());
      inputStream= new ObjectInputStream(socket.getInputStream());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {
    while (true){
      try
      {
        Request response= (Request) inputStream.readObject();
        if ("addUser".equals(response.getType())){
          boolean temp= login.addUser(response.getArg());
          outputStream.writeObject(new Request("addUser",temp));
          break;
        }
        socket.close();
      }
      catch (IOException | ClassNotFoundException e)
      {
        e.printStackTrace();
      }
    }
  }
}
