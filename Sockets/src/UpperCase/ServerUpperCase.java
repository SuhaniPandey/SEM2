package UpperCase;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerUpperCase
{
  public static void main(String[] args)
  {
    System.out.println("Starting server.....");

    try
    {
      ServerSocket welcomeSocket= new ServerSocket(2002);
      while (true){
        Socket socket= welcomeSocket.accept();
        System.out.println("Client Connected.....");

        ObjectInputStream infromClient= new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream outFromClients= new ObjectOutputStream(socket.getOutputStream());

        String readObject = (String) infromClient.readObject();

        String toUpperCase = readObject.toUpperCase();

        outFromClients.writeObject(toUpperCase);
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}
