package Calculator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client_calculator
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    Socket socket= new Socket("LocalHost",1111);

    ObjectOutputStream outToServer= new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inFromServer= new ObjectInputStream(socket.getInputStream());

    //first interger
    System.out.println("Server:\n"+inFromServer.readObject());
    Scanner input= new Scanner(System.in);
    System.out.println("The first integer:\n");
    int user=input.nextInt();
    outToServer.writeObject(user);

    //second integer
    Scanner input1= new Scanner(System.in);
    System.out.println("The second integer:\n");
    int user1=input1.nextInt();
    outToServer.writeObject(user1);

    //calculation received
    int readObject1 = (int) inFromServer.readObject();
    System.out.println("Sum of integers are:"+readObject1);
  }
}
