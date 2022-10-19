package server.model;

import shared.util.Subject;

public interface Login extends Subject
{
  boolean addUser(Object arg);
}
