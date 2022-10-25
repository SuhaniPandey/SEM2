package uppercaseRMI.client.views;

import uppercaseRMI.client.core.ViewHandler;
import uppercaseRMI.client.core.ViewModelFactory;

public interface ViewController {

    void init(ViewHandler vh, ViewModelFactory vmf);

}
