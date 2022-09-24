package task_List.view.remove;

import task_List.core.ViewHandler;
import task_List.model.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class AllTasksController
{

  @FXML private TableView<Task> tableView;
  @FXML private TableColumn<String,Task> columnCreator;
  @FXML private TableColumn<String,Task> descriptionColumn;
  @FXML private TableColumn<String,Task> dateColumn;
  private AllTasksViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(AllTasksViewModel viewModel,ViewHandler viewHandler){
    this.viewModel= viewModel;
    this.viewHandler=viewHandler;
    columnCreator.setCellValueFactory(new PropertyValueFactory<>("owner"));
    descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
    dateColumn.setCellValueFactory(new PropertyValueFactory<>("timeCreated"));
    tableView.setItems(viewModel.getTasks());
  }


  public void onAddButton(ActionEvent actionEvent) throws IOException
  {
    viewHandler.openAddTaskView();
  }

  public void onNextTaskButton(ActionEvent actionEvent) throws IOException
  {
    viewHandler.openAddTaskView();
  }

}
