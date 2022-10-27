package taskList.server;

import taskList.shared.RemoteTaskList;
import taskList.shared.Task;
import taskList.shared.TaskList;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiTextServer implements RemoteTaskList
{
  private TaskList taskList;

  public RmiTextServer()
  {
    try
    {
      UnicastRemoteObject.exportObject(this, 1099);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void add(Task task)
  {
    taskList.add(task);
  }

  @Override public Task remove()
  {
    return taskList.getAndRemoveNextTask();
  }

  @Override public int size()
  {
    return taskList.size();
  }
}
