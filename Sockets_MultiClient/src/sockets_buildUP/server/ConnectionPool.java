package sockets_buildUP.server;

import sockets_buildUP.utill.Message;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
  private List<ServerSocketHandler> conns= new ArrayList<>();

  public void addClient(ServerSocketHandler ssh){
    conns.add(ssh);
  }

  public void removeClient(ServerSocketHandler ssh){
    if (conns.contains(ssh)){
      conns.remove(ssh);
    }
  }

  public void broadCast(Message message){
    for (ServerSocketHandler ssh:conns){
      ssh.sendMessage(message);
    }
  }
}
