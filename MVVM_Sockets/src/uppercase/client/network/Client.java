package uppercase.client.network;

import uppercase.shared.transferobjects.LogEntry;
import uppercase.shared.util.Subject;

import java.util.List;

public interface Client extends Subject
{

    String toUppercase(String str);
    List<LogEntry> getLog();

    void startClient();
}
