package taskList.client;

import uppercaseSimple.client.ClientImpl;

public class ClientRun
{
  public static void main(String[] args)
  {
    RmiTaskClient client= new RmiTaskClient();
    client.startClient("localhost");


  }
}
