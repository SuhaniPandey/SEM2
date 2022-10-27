package uppercaseRMI_MVVM.client.model;



import uppercaseRMI_MVVM.shared.transferobjects.LogEntry;
import uppercaseRMI_MVVM.shared.util.Subject;

import java.util.List;

public interface TextConverter extends Subject
{

    String toUppercase(String text);
    List<LogEntry> getLogs();

}


