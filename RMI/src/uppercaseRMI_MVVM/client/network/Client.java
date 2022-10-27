package uppercaseRMI_MVVM.client.network;



import uppercaseRMI_MVVM.shared.transferobjects.LogEntry;
import uppercaseRMI_MVVM.shared.util.Subject;

import java.util.List;

public interface Client extends Subject
{

    String toUppercase(String str);
    List<LogEntry> getLog();

    void startClient();
}
