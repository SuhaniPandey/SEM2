package model.radiator;

import util.NamedPropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Radiator implements NamedPropertyChangeSubject
{
  private RadiatorState currentState;
  private PropertyChangeSupport support;

  public Radiator(){
    currentState= new OffState();
    support = new PropertyChangeSupport(this);
  }

  public void turnUp()
  {
    currentState.turnUp(this);
    support.firePropertyChange("TemperatureUpdate", null, currentState.getPower());
    System.out.println("Power:"+getPower());
  }
  public void turnDown(){
     currentState.turnDown(this);
    support.firePropertyChange("TemperatureUpdate", null, currentState.getPower());

    System.out.println("Power:"+getPower());
  }
  public int getPower(){
   return currentState.getPower() ;
  }
  void setPowerState(RadiatorState state)
  {
    this.currentState=state;
  }

  @Override public void addListener(String propertName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(propertName, listener);

  }

  @Override public void removeListerner(String propertyName,
      PropertyChangeListener listener)
  {

    support.removePropertyChangeListener(propertyName, listener);
  }
}
