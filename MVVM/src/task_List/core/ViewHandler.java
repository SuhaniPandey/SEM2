package task_List.core;

import task_List.view.add.AddTaskController;
import task_List.view.all.NextTaskController;
import task_List.view.remove.AllTasksController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private Scene addTaskViewModel;
  private Scene removeTaskViewModel;
  private Scene allTasksViewModel;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory){
    this.viewModelFactory=viewModelFactory;
  }

  public void start() throws IOException
  {
    stage= new Stage();
    openAllTasksView();
    openAddTaskView();

  }
  public void openAllTasksView() throws IOException
  {
    FXMLLoader loader= new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/remove/AllTasksView.fxml"));
    Parent root= loader.load();
    AllTasksController view= loader.getController();
    view.init(viewModelFactory.getAllTasksViewModel(),this);
    stage.setTitle("View Tasks");
    stage.setScene(new Scene(root));
    stage.show();
  }

  public void openGetNextTaskView() throws IOException
  {

  }

  public void openAddTaskView() throws IOException
  {
    FXMLLoader loader= new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/add/AddTaskView.fxml"));
    Parent root= loader.load();
    AddTaskController view= loader.getController();
    view.init(viewModelFactory.getAddTaskViewModel(),this);
    stage.setTitle("View Tasks");
    stage.setScene(new Scene(root));
    stage.show();
  }

}
