package Login;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Login
{
  public static void main(String[] args)
  {
    System.out.println("Starting server......");
    try
    {
      ServerSocket welcomeSocket= new ServerSocket(5678);
      while (true){
        Socket socket= welcomeSocket.accept();
        System.out.println("Client Connected.....");

        ObjectInputStream inToClient= new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream outFromClient= new ObjectOutputStream(socket.getOutputStream());

        //connection accepted
        String s = (String) inToClient.readObject();
        System.out.println(s);
        if (s.equals("Connect")){
          System.out.println("Login system is conencted...");
        }
        else {
          break;
        }
        //username
        outFromClient.writeObject("Server:\nUsername:\n>--");
        System.out.println("Username is: "+inToClient.readObject());
        outFromClient.writeObject("Username Accepted....");

        //password
        outFromClient.writeObject("Server:\nPassword:\n>--");
        System.out.println("Password is:"+inToClient.readObject());
        outFromClient.writeObject("Password accepted...");
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }

  }
}
