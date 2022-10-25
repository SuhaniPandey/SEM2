package uppercaseRMI.client;

import javafx.application.Application;
import javafx.stage.Stage;
import uppercaseRMI.client.core.ClientFactory;
import uppercaseRMI.client.core.ModelFactory;
import uppercaseRMI.client.core.ViewHandler;
import uppercaseRMI.client.core.ViewModelFactory;

public class UppercaseApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory cf = new ClientFactory();
        ModelFactory mf = new ModelFactory(cf);
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }
}
