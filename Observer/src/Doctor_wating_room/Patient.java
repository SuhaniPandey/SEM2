package Doctor_wating_room;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Patient implements PropertyChangeListener
{

  private int ticketNumber;
  private WaitingRoom waitingRoom;

  public Patient(int ticketNumber, WaitingRoom waitingRoom)
  {
    this.waitingRoom = waitingRoom;
    this.ticketNumber = ticketNumber;
    System.out.println("Patient " + ticketNumber + " goes to waiting room.");
    waitingRoom.addPropertyChangeListener("WaitingRoom", this);

  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    int value = (int) evt.getNewValue();
    System.out.println("Patient " + ticketNumber + "looks up");
    if (value == ticketNumber)
    {
      System.out.println("Patient " + ticketNumber + "goes to room");
      waitingRoom.removePropertyChangeListener("WaitingRoom", this);
    }
    else
    {
      System.out.println(
          "Patient " + ticketNumber + " goes back to looking at phone.");
    }
  }
}
