package view.temperature;

import core.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TemperatureController
{

  @FXML Label thermomter1Label;
  @FXML Label thermometer2Label;
  @FXML Label thermometer0Label;
  @FXML Label highTemperatureLabel;
  @FXML Label lowTemperatureLabel;
  @FXML Label label;

  private TemperatureViewModel temperatureViewModel;
  private ViewHandler viewHandler;

  public void init(TemperatureViewModel temperatureViewModel, ViewHandler viewHandler)
  {
    this.temperatureViewModel=temperatureViewModel;
    this.viewHandler=viewHandler;
    thermometer0Label.textProperty().bind(temperatureViewModel.thermometer0LabelProperty());
//    thermomter1Label.textProperty().bind(temperatureViewModel.getThermometer1Label());
    thermometer2Label.textProperty().bind(temperatureViewModel.thermometer2LabelProperty());
    highTemperatureLabel.textProperty().bind(temperatureViewModel.highTemperatureLabelProperty());
    lowTemperatureLabel.textProperty().bind(temperatureViewModel.lowTemperatureLabelProperty());
    label.textProperty().bind(temperatureViewModel.labelProperty());
  }
}
