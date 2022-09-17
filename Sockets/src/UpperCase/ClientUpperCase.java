package UpperCase;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientUpperCase
{
  public static void main(String[] args) throws IOException
  {
    Socket socket= new Socket("LocalHost",2002);

    ObjectOutputStream outToServer= new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inFromServer  =new ObjectInputStream(socket.getInputStream());
    Scanner input = new Scanner(System.in);
    System.out.println("Enter any word: ");
    String userInput = input.nextLine();

    outToServer.writeObject(userInput);

    try
    {
      String readObject = (String) inFromServer.readObject();
      System.out.println(readObject);
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }


  }
}
