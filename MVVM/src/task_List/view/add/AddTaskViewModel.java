package task_List.view.add;

import javafx.beans.property.SimpleStringProperty;
import task_List.core.ViewHandler;
import task_List.model.Task;
import task_List.model.TaskModel;
import javafx.beans.property.StringProperty;

public class AddTaskViewModel
{
  private StringProperty creator;
  private StringProperty description;
  private TaskModel model;

  public AddTaskViewModel(TaskModel model){
    this.model=model;
    creator= new SimpleStringProperty();
    description= new SimpleStringProperty();
  }

  public void addNewTask(){
    model.addTask(creator.getValue(), description.getValue());
    System.out.println(creator.getValue()+description.getValue());
    creator.setValue("");
    description.setValue("");
  }

  public StringProperty creatorProperty(){
    return creator;
  }

  public StringProperty descriptionProperty(){
    return description;
  }

}
