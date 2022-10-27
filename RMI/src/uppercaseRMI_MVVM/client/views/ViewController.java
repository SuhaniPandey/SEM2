package uppercaseRMI_MVVM.client.views;

import uppercaseRMI_MVVM.client.core.ViewHandler;
import uppercaseRMI_MVVM.client.core.ViewModelFactory;

public interface ViewController {

    void init(ViewHandler vh, ViewModelFactory vmf);

}
