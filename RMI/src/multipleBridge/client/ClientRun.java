package multipleBridge.client;

import multipleBridge.client.RemoteClient;

import java.util.Scanner;

public class ClientRun
{
  public static void main(String[] args)
  {
    RemoteClient client= new RemoteClient();
    client.strartClient();

    Scanner scan = new Scanner(System.in);
    String read = "";
    String random = "";
    String uppercase="";

    while(true){
      System.out.println("Input >");
      read = scan.nextLine();
      if(read.equalsIgnoreCase("exit")) break;

      random= client.changeToRandomcase(read);
      uppercase= client.changeToUppercase(read);
      System.out.println("Result RANDOM > "+random);
      System.out.println("Result UPPERCASE > "+uppercase);
    }
  }
}
