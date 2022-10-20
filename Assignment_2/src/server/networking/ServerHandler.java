package server.networking;

import server.model.Login;
import shared.User;
import shared.util.Request;

import java.beans.PropertyChangeEvent;
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
    while (true){
      try
      {
        System.out.println("Server handler");
        Request response= (Request) inputStream.readObject();

if ("Listener".equals(response.getType())) {
  login.addListener("NewListener",this::onNewListener);
}
        if ("addUser".equals(response.getType())){
          boolean temp= login.addUser((User) response.getArg());
          outputStream.writeObject(new Request("addUser",temp));

          break;
        }else if ("LoginPossible".equals(response.getType())){
          boolean temp= login.login(user);
          System.out.println(temp + " server handler");
          outputStream.writeObject(new Request("LoginPossible",temp));
          if (temp){
            this.user=user;
            //pool.broadcastUsername(user.getUserName());
          }else if ("UserList".equals(response.getType())){
            outputStream.writeObject(new Request("UserList",temp));
          }
        }

        socket.close();
      }
      catch (IOException | ClassNotFoundException e)
      {
        e.printStackTrace();
      }
    }
  }

  private void onNewListener(PropertyChangeEvent event)
  {
    try
    {
      outputStream.writeObject(new Request(event.getPropertyName(),event.getNewValue()));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
