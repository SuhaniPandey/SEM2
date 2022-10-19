package client.networking;

import shared.User;
import shared.util.Subject;

public interface Client extends Subject
{
  boolean addUser(User user1);
}
