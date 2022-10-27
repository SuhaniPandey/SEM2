package printingMessage;

import java.util.Scanner;

public class RunClient
{
  public static void main(String[] args)
  {
    Client client= new Client();
    client.runClient();

    client.sendText("hello");
    client.sendText("hi");
    client.sendText("how are you?");
  }
}
