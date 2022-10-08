package task_List.core;

import task_List.model.TaskModel;
import task_List.model.TaskModelManager;

public class ModelFactory
{
  private TaskModel taskModel;

  public TaskModel getTaskModel(){
    if (taskModel == null)
    {
      taskModel = new TaskModelManager();
    }
    return taskModel;
  }

}
