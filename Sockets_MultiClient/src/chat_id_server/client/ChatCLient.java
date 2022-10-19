package chat_id_server.client;

import chat_id_server.shared.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class ChatCLient
{
  private ObjectOutputStream outputStream;
  private ObjectInputStream inputStream;
  private Socket socket;

  public void startClient()
  {
    try
    {
      socket = new Socket("LocalHost", 2910);
      outputStream = new ObjectOutputStream(socket.getOutputStream());
      inputStream = new ObjectInputStream(socket.getInputStream());

      Thread thread = new Thread(() -> listenToServer());
      thread.start();

      Scanner scanner = new Scanner(System.in);
      System.out.println("Insert user name>- ");
      String userName = scanner.nextLine();
      System.out.println("Write to other client:>");
      outputStream.writeObject(userName);

      while (true)
      {
        String msg = scanner.nextLine();
        Message m = new Message(msg, userName);
        outputStream.writeObject(m);

        if (msg.equalsIgnoreCase("exit"))
        {
          break;
        }

      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void listenToServer()
  {
    try
    {
      while (true)
      {
        Message response = (Message) inputStream.readObject();
        if (response.getMessageBody().equalsIgnoreCase("exit"))
        {
          socket.close();
          break;
        }
        System.out.println(response);
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}
