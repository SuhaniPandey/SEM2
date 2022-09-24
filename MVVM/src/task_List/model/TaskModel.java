package task_List.model;

import java.beans.PropertyChangeListener;

public interface TaskModel
{
  public void addTask(String owner,String desc);
  public Task getTask();
  public void addListener(String eventName, PropertyChangeListener listener);
}
