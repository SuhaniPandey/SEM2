package task_List.view.all;

import task_List.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;

public class NextTaskController
{
  @FXML private Label descLabel;
  @FXML private Label createdLabel;
  @FXML private Label timeLabel;
  private NextTaskViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler,NextTaskViewModel viewModel){
    this.viewModel=viewModel;
    this.viewHandler=viewHandler;
  }

  public void onGetTaskButton(ActionEvent actionEvent) throws IOException
  {

  }

  public void onBackBotton(ActionEvent actionEvent) throws IOException
  {

  }
}
