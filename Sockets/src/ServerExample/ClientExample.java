package ServerExample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientExample
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    Socket socket=  new Socket("Localhost",2910);

    ObjectOutputStream outToServer= new ObjectOutputStream(socket.getOutputStream());
    outToServer.writeObject("Hello");

    ObjectInputStream inFromServer= new ObjectInputStream(socket.getInputStream());
    String o= (String)inFromServer.readObject();
    System.out.println(o);
  }
}
