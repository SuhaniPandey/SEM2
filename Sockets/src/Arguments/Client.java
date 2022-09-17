package Arguments;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    Socket socket = new Socket("LocalHost", 2111);

    ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

    // HOw can I help you received.....
    String readObject = (String) inFromServer.readObject();
    System.out.println(readObject);

    //uppercase or lowercase??
    outToServer.writeObject("UpperCase or Lowercase?");

    // argument received
    String readObject1 = (String) inFromServer.readObject();
    System.out.println(readObject1);

    while (true)
    {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter any word: ");
      String userInput = input.nextLine();
      outToServer.writeObject(userInput);

      String o = (String) inFromServer.readObject();
      System.out.println(o);
      if(userInput.equals("End")){
        System.out.println("Program ends here....");
        socket.close();
        break;
      }
      }

  }
}