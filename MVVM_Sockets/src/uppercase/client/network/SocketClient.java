package uppercase.client.network;

import uppercase.shared.transferobjects.LogEntry;
import uppercase.shared.transferobjects.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SocketClient implements Client {

    private PropertyChangeSupport support;

    public SocketClient() {
        support = new PropertyChangeSupport(this);
    }

    public void startClient() {
        try {
            Socket socket = new Socket("localhost", 2900);
            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

            new Thread(() -> listenToServer(outToServer, inFromServer)).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listenToServer(ObjectOutputStream outToServer, ObjectInputStream inFromServer) {
        try {
            outToServer.writeObject(new Request("Listener", null));
            while (true) {
                Request request = (Request) inFromServer.readObject();
                support.firePropertyChange(request.getType(), null, request.getArg());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toUppercase(String str) {
        try {
            Request response = request(str, "Uppercase");
            return (String)response.getArg();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return str;
    }

   /* @Override
    public List<LogEntry> getLog() {
        try {
            Request response = request(null, "FetchLog");
            return (List<LogEntry>) response.getArg();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    public List<LogEntry> getLog(){
        Request response= null;
        try
        {
            response = request(null,"FetchLog");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return (List<LogEntry>) response.getArg();
    }

    private Request request(String arg, String type) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 2900);
        ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
        outToServer.writeObject(new Request(type, arg));
        return (Request) inFromServer.readObject();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
