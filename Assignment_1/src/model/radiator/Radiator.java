package model.radiator;

import util.NamedPropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Radiator
{
  private RadiatorState currentState;

  public Radiator(){
    currentState= new OffState();
  }

  public void turnUp()
  {
    currentState.turnUp(this);
    System.out.println("Power:"+getPower());
  }
  public void turnDown(){
     currentState.turnDown(this);
    System.out.println("Power:"+getPower());
  }
  public int getPower(){
   return currentState.getPower() ;
  }
  void setPowerState(RadiatorState state)
  {
    this.currentState=state;
  }

}
