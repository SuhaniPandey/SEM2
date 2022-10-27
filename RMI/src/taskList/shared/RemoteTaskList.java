package taskList.shared;

import java.rmi.Remote;

public interface RemoteTaskList extends Remote
{
  void add(Task task);
  Task remove();
  int size();
}
