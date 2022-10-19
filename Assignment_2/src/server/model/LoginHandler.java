package server.model;

import java.beans.PropertyChangeListener;

public class LoginHandler implements Login
{
  @Override public boolean addUser(Object arg)
  {
    return false;
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {

  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {

  }
}
