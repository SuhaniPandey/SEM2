package uppercaseRMI_MVVM.client;

import javafx.application.Application;
import javafx.stage.Stage;
import uppercaseRMI_MVVM.client.core.ClientFactory;
import uppercaseRMI_MVVM.client.core.ModelFactory;
import uppercaseRMI_MVVM.client.core.ViewHandler;
import uppercaseRMI_MVVM.client.core.ViewModelFactory;

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
