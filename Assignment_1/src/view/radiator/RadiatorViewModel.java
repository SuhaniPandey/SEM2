package view.radiator;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.radiator.Radiator;

import java.beans.PropertyChangeEvent;

public class RadiatorViewModel
{
  private Radiator radiator;
  private StringProperty currentStateLabel;
  private StringProperty stateChangedLabel;



  public RadiatorViewModel(Radiator radiator)
  {
    this.radiator=radiator;
    currentStateLabel= new SimpleStringProperty();
    stateChangedLabel= new SimpleStringProperty();
    currentStateLabel.set(String.valueOf(radiator.getPower()));
    radiator.addListener("TemperatureUpdate", this::update);

  }

  private void update(PropertyChangeEvent event)
  {
    Integer newValue =(Integer) event.getNewValue();
    new Thread(()->{
      Platform.runLater(()->{
        currentStateLabel.setValue(newValue + "");
      });
    }).start();
  }

  public StringProperty getStateChangedLabel(){
    if (radiator.getPower()==3){
      stateChangedLabel.setValue("Power is at max");
    }
    else if (radiator.getPower()==0){
      stateChangedLabel.setValue("Power cannot be lowered down");
    }
    return stateChangedLabel;
  }

  public StringProperty currentStateLabelProperty()
  {

    return currentStateLabel;
  }

  public void onDecreaseButton(){
    radiator.turnDown();

  }

  public void onIncreaseButton(){
    radiator.turnUp();

  }


}
