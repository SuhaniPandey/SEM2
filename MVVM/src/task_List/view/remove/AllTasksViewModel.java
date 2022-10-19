package task_List.view.remove;

import task_List.model.Task;
import task_List.model.TaskModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;

public class AllTasksViewModel
{
  private ObservableList<Task> tasks;
  private TaskModel model;

  public AllTasksViewModel(TaskModel model){
    this.model=model;
    tasks= FXCollections.observableArrayList();
    model.addListener("AddTask",this::taskAdded);
    model.addListener("RemoveTask",this::taskRemoved);
  }


  private void taskRemoved(PropertyChangeEvent event)
  {

    tasks.remove((Task) event.getNewValue());
  }

  private void taskAdded(PropertyChangeEvent event)
  {
    tasks.add((Task) event.getNewValue());
  }

  public ObservableList<Task> getTasks(){
    return tasks;
  }
}
