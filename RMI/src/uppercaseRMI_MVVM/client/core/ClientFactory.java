package uppercaseRMI_MVVM.client.core;

import uppercaseRMI_MVVM.client.network.Client;
import uppercaseRMI_MVVM.client.network.RMIClient;

public class ClientFactory {

    private Client client;

    public Client getClient() {
        if(client == null) {
            client = new RMIClient();
        }
        return client;
    }
}
