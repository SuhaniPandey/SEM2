package taskList.shared;

import java.util.ArrayList;

public class TaskList
{
  private ArrayList<Task> tasks;

  public TaskList()
  {
    tasks= new ArrayList<>();
  }

  public void add(Task task){
    tasks.add(task);
  }

  public Task getAndRemoveNextTask(){
    Task task=null;
    for (int i = 0; i < tasks.size(); i++)
    {
      task=tasks.remove(i);
    }
    return task;
  }

  public int size(){
    return tasks.size();
  }
}
