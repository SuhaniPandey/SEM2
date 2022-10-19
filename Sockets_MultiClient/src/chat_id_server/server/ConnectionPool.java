package chat_id_server.server;

import chat_id_server.shared.Message;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
  private List<ServerSocketHandler> conns= new ArrayList<>();
  public void addConnection(ServerSocketHandler csh){
    conns.add(csh);
  }
  
  public void broadcast(Message msg){
    for (ServerSocketHandler conn : conns)
    {
      if (!conn.getClientName().equals(msg.getUser()))
     conn.sendMessageToClient(msg);
    }
  }

  public void removeConnection(ServerSocketHandler serverSocketHandler)
  {
    conns.remove(serverSocketHandler);
  }
}
