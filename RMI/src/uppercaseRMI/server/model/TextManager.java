package uppercaseRMI.server.model;






import uppercaseRMI.shared.transferobjects.LogEntry;
import uppercaseRMI.shared.util.Subject;

import java.util.List;

public interface TextManager extends Subject
{

    String toUppercase(String str);
    List<LogEntry> getLog();
}
