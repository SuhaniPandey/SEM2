package Login;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client_login
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    Socket socket= new Socket("LocalHost",5678);

    ObjectOutputStream outToServer= new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inFromServer= new ObjectInputStream(socket.getInputStream());

    //connect
while (true)
{
  Scanner Input = new Scanner(System.in);
  System.out.println("Write >>Connect<< if you want to connect to the system");
  String userInput2 = Input.nextLine();
  outToServer.writeObject(userInput2);
  if (!(userInput2.equals("Connect"))){
    System.out.println("Must write connect in order to run the program....");
    System.out.println("Program ended.....");
    break;
  }

  //username
  String readObject = (String) inFromServer.readObject();
  System.out.println(readObject);
  Scanner input = new Scanner(System.in);
  String userInput = input.nextLine();

  outToServer.writeObject(userInput);

  System.out.println(inFromServer.readObject());
  //password
  System.out.println(inFromServer.readObject());
  Scanner input1 = new Scanner(System.in);
  String userInput1 = input1.nextLine();
  outToServer.writeObject(userInput1);
  System.out.println(inFromServer.readObject());
  break;
}
  }
}
