package Arguments;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    System.out.println("Server Connecting............");

    ServerSocket welcomeSocket= new ServerSocket(2111);
    while (true){
      Socket socket= welcomeSocket.accept();
      System.out.println("Client connected");

      ObjectInputStream inFromClient= new ObjectInputStream(socket.getInputStream());
      ObjectOutputStream outFromClient= new ObjectOutputStream(socket.getOutputStream());

     outFromClient.writeObject("How can i help you?");

     //Uppercase or lowercase received.....
      String readObject = (String) inFromClient.readObject();
      System.out.println(readObject);

      //respond argument
      outFromClient.writeObject("Argument?");
      // receive input
      while (true)
      {
        String readObject2 = (String) inFromClient.readObject();

        String uppercase = readObject2.toUpperCase();
        outFromClient.writeObject(uppercase);


      }
    }

  }
}
