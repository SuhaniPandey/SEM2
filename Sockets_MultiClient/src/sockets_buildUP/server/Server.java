package sockets_buildUP.server;

import sockets_buildUP.utill.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void startServer() {
        System.out.println("Starting server...");
        try{
            ServerSocket serverSocket = new ServerSocket(2910);
            ConnectionPool connectionPool= new ConnectionPool();

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");


                ServerSocketHandler serverSocketHandler= new ServerSocketHandler(socket,connectionPool);
                connectionPool.addClient(serverSocketHandler);
                Thread thread= new Thread(serverSocketHandler);
                thread.start();


            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
