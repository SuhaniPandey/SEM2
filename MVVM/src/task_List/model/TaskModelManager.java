package task_List.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskModelManager implements TaskModel
{
  private List<Task> tasks;
  private PropertyChangeSupport support;

  public TaskModelManager(){
    support= new PropertyChangeSupport(this);
    tasks= new ArrayList<>();
  }


  @Override public void addTask(String owner, String desc)
  {
    Task task= new Task(owner,desc,calcTimeStamp());
    tasks.add(task);
    support.firePropertyChange("AddTask",null,task);

  }

  @Override public Task getTask()
  {
    Task task= tasks.remove(0);
    support.firePropertyChange("RemoveTask",null,task);
    return task;
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  private String calcTimeStamp(){
    SimpleDateFormat sdfDate=  new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
    Date now= new Date();
    return sdfDate.format(now);
  }
}
