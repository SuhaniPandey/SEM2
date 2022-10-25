package uppercaseRMI.client.model;



import uppercaseRMI.shared.transferobjects.LogEntry;
import uppercaseRMI.shared.util.Subject;

import java.util.List;

public interface TextConverter extends Subject
{

    String toUppercase(String text);
    List<LogEntry> getLogs();

}


