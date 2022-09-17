package ServerExample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    System.out.println("Starting server....");

    ServerSocket welcomeSocket = new ServerSocket(2910);
    while (true){
      Socket socket= welcomeSocket.accept();
      System.out.println("Client connected");

      ObjectInputStream infromCLient= new ObjectInputStream(socket.getInputStream());
      String o= (String) infromCLient.readObject();
      System.out.println("Received: "+o);

      String answer= o.toUpperCase();

      ObjectOutputStream outToClient= new ObjectOutputStream(socket.getOutputStream());
      outToClient.writeObject(answer);
    }
  }
}
