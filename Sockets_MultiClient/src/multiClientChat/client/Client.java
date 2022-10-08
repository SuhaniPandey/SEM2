package multiClientChat.client;

import multiClientChat.shared.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
  private ObjectOutputStream outputStream;
  private ObjectInputStream inputStream;
  public void Client(){
    
  }

  public void startClient() throws IOException
  {

      Socket socket= new Socket("localHost",2910);
      outputStream= new ObjectOutputStream(socket.getOutputStream());
      inputStream= new ObjectInputStream(socket.getInputStream());
     Thread thread= new Thread(()-> {
       try
       {
         listenToServer();
       }
       catch (IOException e)
       {
         e.printStackTrace();
       }
       catch (ClassNotFoundException e)
       {
         e.printStackTrace();
       }
     });
     thread.setDaemon(true);
     thread.start();

      Scanner scanner= new Scanner(System.in);
    System.out.println("Insert user name>>");
    String userName= scanner.nextLine();
    outputStream.writeObject(userName);
      while (true){
        String msg= scanner.nextLine();
        Message message= new Message(msg,userName);
        outputStream.writeObject(message);
        if (msg.equalsIgnoreCase("exit")){
          socket.close();
          break;
        }
      }
    }


  private void listenToServer()
      throws IOException, ClassNotFoundException
  {
    while (true)
    {
      Message response=(Message) inputStream.readObject();
      System.out.println(response);
    }
  }
}
