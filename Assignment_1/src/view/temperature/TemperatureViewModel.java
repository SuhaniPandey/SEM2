package view.temperature;

import core.ModelFactory;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.temperature.Temperature;

import java.beans.PropertyChangeEvent;

public class TemperatureViewModel
{
  private StringProperty thermometer1Label, thermometer2Label, thermometer0Label,
      highTemperatureLabel, lowTemperatureLabel, label;
  private ModelFactory modelFactory;


  public TemperatureViewModel(ModelFactory modelFactory){
    this.modelFactory=modelFactory;
    thermometer0Label= new SimpleStringProperty();
    thermometer1Label= new SimpleStringProperty();
    thermometer2Label= new SimpleStringProperty();
    highTemperatureLabel= new SimpleStringProperty();
    lowTemperatureLabel= new SimpleStringProperty();
    label= new SimpleStringProperty();
    modelFactory.getTemperatureModel().addListener("TemperatureAdded",this::indoorTemperatureChanged);
    modelFactory.getTemperatureModel().addListener("OutsideTemperature",this::outdoorTemperature);
  }

  private void outdoorTemperature(PropertyChangeEvent event)
  {
    Temperature temperature=(Temperature) event.getNewValue();
    System.out.println(temperature);
    if (temperature.getId().equals("t0")){
      Platform.runLater(()-> thermometer0Label.set((temperature.getValue()+"")));

    }
    else
    {
      Platform.runLater(() -> thermometer0Label.set(""));
    }
  }

  private void indoorTemperatureChanged(PropertyChangeEvent event)
  {
    Temperature temperature= (Temperature) event.getNewValue();
    if (temperature.getId().equals("t1")){
      if (temperature.getValue()> 10 ){
        Platform.runLater(() -> highTemperatureLabel.set(temperature.getValue()+""));
        Platform.runLater(() -> label.set("December feels like july...lower the temperature"));
      }
      else {
        Platform.runLater(() -> highTemperatureLabel.set(""));
        Platform.runLater(() -> label.set(""));
      }
      Platform.runLater(() -> thermometer1Label.set(temperature.getValue()+" "));
    }
    else if (temperature.getId().equals("t2")){
      if (temperature.getValue()< 2){
        Platform.runLater(() -> lowTemperatureLabel.set(temperature.getValue()+""));
        Platform.runLater(() -> label.set("Its freezing cold....turn on the heater"));
      }
      else {
        Platform.runLater(() -> lowTemperatureLabel.set(""));
        Platform.runLater(() -> label.set(""));
      }
      Platform.runLater(() -> thermometer2Label.set(temperature.getValue()+" "));
    }
    else {
      Platform.runLater(() -> thermometer1Label.set(""));
      Platform.runLater(() ->thermometer2Label.set(""));
    }
  }


  public StringProperty labelProperty()
  {
    return label;
  }

  public StringProperty getThermometer1Label()
  {
    return thermometer1Label;
  }


  public StringProperty thermometer2LabelProperty()
  {
    return thermometer2Label;
  }

  public StringProperty thermometer0LabelProperty()
  {
    return thermometer0Label;
  }

  public StringProperty highTemperatureLabelProperty()
  {
    return highTemperatureLabel;
  }

  public StringProperty lowTemperatureLabelProperty()
  {
    return lowTemperatureLabel;
  }
}
