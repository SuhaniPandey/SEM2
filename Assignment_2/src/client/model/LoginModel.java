package client.model;

import shared.util.Subject;

public interface LoginModel extends Subject
{
  boolean addUser(String username, String password);
}
