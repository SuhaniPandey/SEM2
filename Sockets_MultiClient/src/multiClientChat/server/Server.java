package multiClientChat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  public void start()
  {
    try
    {
      ServerSocket serverSocket= new ServerSocket(2910);
      ConnectionPool pool= new ConnectionPool();
      System.out.println("Server started...");

      while (true){
        Socket socket= serverSocket.accept();
        ServerSocketHandler serverSocketHandler= new ServerSocketHandler(socket,pool);
        pool.addConnection(serverSocketHandler);
        Thread th= new Thread(serverSocketHandler);
        th.start();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
