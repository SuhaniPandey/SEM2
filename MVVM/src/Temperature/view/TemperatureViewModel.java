package Temperature.view;

import Temperature.mediator.TemperatureModel;
import Temperature.model.Temperature;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureViewModel implements PropertyChangeListener
{

  private StringProperty outputLabel;
  private StringProperty filterLabel;
  private StringProperty filterField;
  private String thermometerId;

  private TemperatureModel model;


  public TemperatureViewModel(TemperatureModel model){
    this.model=model;
    outputLabel= new SimpleStringProperty();
    filterField= new SimpleStringProperty();
    filterLabel= new SimpleStringProperty();
  }


  public void getValue()
  {
    Temperature t1= model.getLastInsertedTemperature("t1");
      Temperature t2= model.getLastInsertedTemperature("t2");
         if (thermometerId.equals("t1")){
           outputLabel.setValue(t1.toString());
         }
          else if(thermometerId.equals("t2")){
             outputLabel.setValue(t2.toString());
          }
          else if (thermometerId.equals("")){
             outputLabel.setValue(t1.toString()+"\n"+t2.toString());
          }
  }

  public void updateThermometerID()
  {
    Temperature t1= model.getLastInsertedTemperature("t1");
    Temperature t2= model.getLastInsertedTemperature("t2");
    thermometerId= filterField.getValue();
    if (thermometerId.equals("")){
    filterLabel.setValue("All");
    getValue();
    }
    else if (thermometerId.equals("t1")){
    filterLabel.setValue("t1");
     getValue();
    }
     else if (thermometerId.equals("t2")){
    filterLabel.setValue("t2");
    getValue();
     }
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {

      Temperature t1 = (Temperature) evt.getNewValue();
      Temperature t2 = (Temperature) evt.getOldValue();
      //      Platform.runLater(() ->outputLabel.setText(evt.getNewValue().toString()));
      Platform.runLater(() ->outputLabel.setValue(t1.toString()+ " \n " + t2.toString()));

  }
}
