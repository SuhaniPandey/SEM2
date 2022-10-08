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
    radiator.getPower();
    Platform.runLater(() ->currentStateLabel.setValue(String.valueOf(radiator.getPower())));
    if (radiator.getPower()==0){
      Platform.runLater(() ->stateChangedLabel.setValue("Its gonna be freezing cold....temperature is minimum at "));
    }
    else {
      Platform.runLater(() ->stateChangedLabel.setValue(""));
    }
  }

  public void onIncreaseButton(){
    radiator.turnUp();
    radiator.getPower();
    Platform.runLater(() ->currentStateLabel.setValue(String.valueOf(radiator.getPower())));
    if (radiator.getPower()==3){
      Platform.runLater(() ->stateChangedLabel.setValue("wanna boil your blood cuz temperature is at max...."));
    }
    else {
      Platform.runLater(() ->stateChangedLabel.setValue(""));
    }
  }


}
