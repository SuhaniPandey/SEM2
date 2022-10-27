package uppercaseSimple.client;

import java.util.Scanner;

public class RunClient {
    public static void main(String[] args) {

        ClientImpl client = new ClientImpl();
        client.initializeConnection(); //get access to the server

        Scanner scan = new Scanner(System.in);
        String read = "";
        String result = "";

        while(true){
            System.out.println("Input >");
            read = scan.nextLine();
            if(read.equalsIgnoreCase("exit")) break;

            result= client.toUpperCase(read);
            System.out.println("Result > "+result);
        }

    }
}
