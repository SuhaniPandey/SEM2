package upperCase.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UppercaseViewController
{
  @FXML
  private TextField requestField;
  @FXML
  private TextField replyField;
  @FXML
  private Label errorField;
  private UppercaseViewModel viewModel;

  @FXML
  public void onSubmitButton(ActionEvent actionEvent)
  {
    viewModel.convert();
  }

  public void init(UppercaseViewModel uppercaseViewModel){
    this.viewModel= uppercaseViewModel;
    errorField.textProperty().bind(viewModel.errorProperty());
    requestField.textProperty().bindBidirectional(viewModel.requestProperty());
    replyField.textProperty().bind(viewModel.replyProperty());
    replyField.setDisable(true);
  }


}
