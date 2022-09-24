package task_List.view.add;

import task_List.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddTaskController
{
  @FXML
  private TextField creatorTextField;
  @FXML
  private TextField descriptionTextField;
  private AddTaskViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(AddTaskViewModel viewModel,ViewHandler viewHandler){
    this.viewModel=viewModel;
    this.viewHandler=viewHandler;
    creatorTextField.textProperty().bindBidirectional(viewModel.creatorProperty());
    descriptionTextField.textProperty().bindBidirectional(viewModel.descriptionProperty());
  }

  public void onAddButton(ActionEvent actionEvent) throws IOException
  {
    viewModel.addNewTask();
  }

  public void onBackBotton(ActionEvent actionEvent) throws IOException
  {
    viewHandler.openAllTasksView();
  }
}
