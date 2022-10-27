package uppercaseRMI_MVVM.server.model;






import uppercaseRMI_MVVM.shared.transferobjects.LogEntry;
import uppercaseRMI_MVVM.shared.util.Subject;

import java.util.List;

public interface TextManager extends Subject
{

    String toUppercase(String str);
    List<LogEntry> getLog();
}
