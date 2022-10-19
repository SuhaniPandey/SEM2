package uppercase.client;

import java.util.Scanner;

public class RunClient
{
  public static void main(String[] args)
  {
    ClientImpl client= new ClientImpl();
    client.initializaConnection();//get access to the server

    Scanner scanner= new Scanner(System.in);
    String road="";
    String result="";
    while (true){
      System.out.println("Input>-");
      road= scanner.nextLine();
      if (road.equalsIgnoreCase("exit"))break;
      result= client.toUpperCase(road);
      System.out.println("Result>-"+result);

    }
  }
}
