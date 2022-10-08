package view.radiator;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RadiatorController
{
  
  @FXML Label currentStateLabel;
  @FXML Label stateChangedLabel;
  private RadiatorViewModel radiatorViewModel;
  private ViewHandler viewHandler;

  public RadiatorController()
  {

  }

  public void init(RadiatorViewModel radiatorViewModel,ViewHandler viewHandler)
  {
    this.radiatorViewModel=radiatorViewModel;
    this.viewHandler= viewHandler;
    currentStateLabel.textProperty().bind(radiatorViewModel.currentStateLabelProperty());
    stateChangedLabel.textProperty().bind(radiatorViewModel.getStateChangedLabel());
  }

  public void onIncreaseButton()
  {
    radiatorViewModel.onIncreaseButton();
  }

  public void onDecreaseButton()
  {
    radiatorViewModel.onDecreaseButton();
  }

}
