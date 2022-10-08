package multiClientChat.server;

import multiClientChat.shared.Message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
  private List<ServerSocketHandler> conns= new ArrayList<>();
  
  public void addConnection(ServerSocketHandler serverSocketHandler){
    conns.add(serverSocketHandler);
  }
  
  public void broadCast(Message message) throws IOException
  {
    for (ServerSocketHandler conn : conns)
    {
      if (conn.getClientName().equals(message.getUser())){
        conn.sendMessage(message);
      }

    }
  }
}
