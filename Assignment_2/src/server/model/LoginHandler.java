package server.model;

import shared.ListOfUsers;
import shared.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.net.Socket;
import java.util.List;

public class LoginHandler implements Login

{
  private PropertyChangeSupport support;
  private ListOfUsers listOfUsers;

  public LoginHandler()
  {
    support = new PropertyChangeSupport(this);
    listOfUsers = new ListOfUsers();
  }

  @Override public boolean addUser(User user)
  {
    listOfUsers.addUser(user);
    return true;
  }

  @Override public boolean login(User user)
  {
    boolean status = listOfUsers.haveUsers(user);
    if (status) {
      support.firePropertyChange("NewListener",null,user);
    }
    return status;
  }

  @Override public List<String> getAllUsers()
  {
    return listOfUsers.userNames();
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName,listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName,listener);
  }
}
