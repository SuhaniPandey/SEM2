package Calculator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_calculator
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    System.out.println("Starting server....");
    ServerSocket welcomeSocket= new ServerSocket(1111);
    while (true){
      Socket socket= welcomeSocket.accept();
      System.out.println("Client connected....");

      ObjectInputStream outFromClient= new ObjectInputStream(socket.getInputStream());
      ObjectOutputStream inToClient= new ObjectOutputStream(socket.getOutputStream());

      inToClient.writeObject("Send integer to server");
      int readObject = (int) outFromClient.readObject();
      System.out.println("First integer:"+readObject);
      int readObject1 = (int) outFromClient.readObject();
      System.out.println("Second integer:"+readObject1);

      //calculation
      inToClient.writeObject(readObject+readObject1);

    }
  }
}
