package uppercaseRMI.client.core;

import uppercaseRMI.client.network.Client;
import uppercaseRMI.client.network.RMIClient;

public class ClientFactory {

    private Client client;

    public Client getClient() {
        if(client == null) {
            client = new RMIClient();
        }
        return client;
    }
}
