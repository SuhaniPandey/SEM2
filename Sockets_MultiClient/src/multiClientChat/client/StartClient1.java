package multiClientChat.client;

import java.io.IOException;

public class StartClient1
{
  public static void main(String[] args) throws IOException
  {
    Client client= new Client();
    client.startClient();
  }
}
