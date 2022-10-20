package client.model;

import shared.User;
import shared.util.Subject;

public interface LoginModel extends Subject
{
  boolean addUser(String username, String password);

  User getUser();

  boolean login(User user);
}
