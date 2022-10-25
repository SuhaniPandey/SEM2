package uppercaseRMI.client.network;



import uppercaseRMI.shared.transferobjects.LogEntry;
import uppercaseRMI.shared.util.Subject;

import java.util.List;

public interface Client extends Subject
{

    String toUppercase(String str);
    List<LogEntry> getLog();

    void startClient();
}
