package uppercase.client.core;

import uppercase.client.network.Client;
import uppercase.client.network.SocketClient;

public class ClientFactory {

    private Client client;

    public Client getClient() {
        if(client == null) {
            client = new SocketClient();
        }
        return client;
    }
}
