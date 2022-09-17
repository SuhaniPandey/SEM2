package Chat_1to1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server_chat
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    System.out.println("Starting server....");

    ServerSocket welcomeSocket= new ServerSocket(2222);
    while (true){
      Socket socket= welcomeSocket.accept();
      System.out.println("Client connected......");

      ObjectInputStream inToClient= new ObjectInputStream(socket.getInputStream());
      ObjectOutputStream outFromClient= new ObjectOutputStream(socket.getOutputStream());

      while (true)
      {
        Scanner input = new Scanner(System.in);
        System.out.println("Server:");
        String user = input.nextLine();
        outFromClient.writeObject(user);
        String readObject = (String) inToClient.readObject();
        System.out.println("Client:" + readObject);
        if (user.equals("End")){
          System.out.println("Chat ends here");
          break;
        }
      }
    }
  }
}
