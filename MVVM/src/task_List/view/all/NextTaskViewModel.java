package task_List.view.all;

import task_List.model.TaskModel;
import javafx.beans.property.StringProperty;

public class NextTaskViewModel
{
  private StringProperty description;
  private StringProperty date;
  private StringProperty creator;
  private TaskModel model;


  public NextTaskViewModel(TaskModel model){
    this.model=model;
  }

  public void getNextTask(){

  }
  public void clearData(){

  }
  public StringProperty descriptionProperty(){
    return description;
  }

  public StringProperty creatorProperty(){
    return creator;
  }

  public StringProperty dateProperty(){
    return date;
  }
}
