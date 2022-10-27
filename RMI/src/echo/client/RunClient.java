package echo.client;

import echo.client.EchoClient;

import java.util.Scanner;

public class RunClient
{
  public static void main(String[] args)
  {
    EchoClient client= new EchoClient();
    client.startClient();

    Scanner scanner= new Scanner(System.in);

    while (true){
      System.out.println("Input>-");
      String read= scanner.nextLine();

      if (read.equalsIgnoreCase("exit")) break;

      String result= client.addMessage(read);
      System.out.println("Result>-"+result);
    }
  }
}
