package Chat_1to1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client_chat
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    Socket socket= new Socket("LocalHost",2222);

    ObjectOutputStream outToServer= new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inFromServer= new ObjectInputStream(socket.getInputStream());

    while (true)
    {
      String readObject = (String) inFromServer.readObject();
      System.out.println("Server:" + readObject);
      Scanner input = new Scanner(System.in);
      System.out.println("Client:");
      String user = input.nextLine();
      outToServer.writeObject(user);
      if (user.equals("End")){
        System.out.println("Chat ends here");
        break;
      }
    }
  }
}
