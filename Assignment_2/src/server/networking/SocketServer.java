package server.networking;

import server.model.Login;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private Login login;

  public SocketServer(Login login){
    this.login=login;
  }

  public void startServer(){
    try
    {
      ServerSocket socket= new ServerSocket(2002);
      System.out.println("Server starting...");
      while (true){
        Socket socket1= socket.accept();
        Thread th= new Thread();
        th.start();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
