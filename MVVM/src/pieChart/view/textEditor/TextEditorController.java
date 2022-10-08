package pieChart.view.textEditor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TextEditorController
{
  @FXML TextField xTextField;
  @FXML TextField yTextField;
  @FXML TextField zTextField;

  private TextEditorViewModel viewModel;

  public void init(TextEditorViewModel viewModel){
    this.viewModel=viewModel;
    xTextField.textProperty().bindBidirectional(viewModel.xProperty());
    yTextField.textProperty().bindBidirectional(viewModel.yProperty());
    zTextField.textProperty().bindBidirectional(viewModel.zProperty());
  }
  public void onUpdateButton(ActionEvent actionEvent)
  {
    viewModel.updateTextField();
  }

  public void onSaveButton(ActionEvent actionEvent)
  {
    viewModel.saveChanges();
  }
}
