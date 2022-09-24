package task_List.core;

import task_List.model.TaskModel;
import task_List.model.TaskModelManager;

public class ModelFactory
{
  private TaskModel taskModelManager;

  public TaskModel getTaskModelManager(){
    taskModelManager= new TaskModelManager();
    return taskModelManager;
  }

}
