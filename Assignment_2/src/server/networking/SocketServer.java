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
      ServerSocket socket= new ServerSocket(2001);
      System.out.println("Server starting...");
      while (true){
        Socket socket1= socket.accept();
        ServerHandler serverHandler= new ServerHandler(socket1,login);
        Thread th= new Thread(serverHandler);
        th.start();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
