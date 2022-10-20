package client.networking;

import shared.User;
import shared.util.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ClientSocket implements Client
{
  private PropertyChangeSupport support;

  public ClientSocket()
  {
    support= new PropertyChangeSupport(this);
  }

  @Override public void listenToServer(User user)
  {
    try
    {
      Socket socket= new Socket("localhost",2001);
      ObjectOutputStream outputStream= new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inputStream= new ObjectInputStream(socket.getInputStream());

      Thread th= new Thread(() -> listenToServer(inputStream,outputStream,user));
      th.start();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public List<String> getUserList()
  {
    Request response= request(null,"UserList");
    return (List<String>) response.getArg();
  }

  @Override public boolean addUser(User user1)
  {
    Request response= request(user1,"addUser");
    assert response != null;
    return (boolean) response.getArg();
  }

  @Override public boolean login(User user)
  {
    try
    {
      Request response= request(user,"LoginPossible");
      System.out.println("client socket");
      assert response != null;
      boolean isPossible= (boolean) response.getArg();
      if (isPossible){
        listenToServer(user);
      }
      return isPossible;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return false;
  }

  private Request request(Object arg, String type){
    try
    {
      Socket socket= new Socket("localhost",2001);
      ObjectOutputStream outputStream= new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inputStream= new ObjectInputStream(socket.getInputStream());
      outputStream.writeObject(new Request(type, arg));
      return (Request) inputStream.readObject();
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  private void listenToServer(ObjectInputStream inputStream,ObjectOutputStream outputStream, User user){
    try
    {
      outputStream.writeObject(new Request("Listener",user));
      while (true){
        Request response= (Request) inputStream.readObject();
        if (response.getType().equals("userAdded")){
          support.firePropertyChange("userAdded",null,response.getArg());
        }
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}
