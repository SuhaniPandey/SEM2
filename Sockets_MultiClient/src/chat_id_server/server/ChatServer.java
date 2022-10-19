package chat_id_server.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer
{
  public void start()
  {
    try
    {
      ServerSocket serverSocket=new ServerSocket(2910);
      ConnectionPool connectionPool= new ConnectionPool();
      System.out.println("Server started....");
      while (true){
        Socket socket= serverSocket.accept();
        ServerSocketHandler csh= new ServerSocketHandler(socket,connectionPool);
        connectionPool.addConnection(csh);
        Thread t= new Thread(csh);
        t.start();
        //TODO add to connection poool



      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
