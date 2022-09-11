package Traffic_Light;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Car
{
  private String previousLight;
  private int id;

  public Car(int id)
  {
    this.id = id;
  }

  public void setLight(String currentLight)
  {
    if ("GREEN".equals(currentLight))
    {
      System.out.println("Car " + id + " drives");
    }
    else if ("YELLOW".equals(currentLight))
    {
      if ("RED".equals(previousLight))
      {
        System.out.println("Car " + id + " turns engine on");
      }
      else
      {
        System.out.println("Car " + id + " slows down");
      }
    }
    else if ("RED".equals(currentLight))
    {
      System.out.println("Car " + id + " stops");
    }
    previousLight = currentLight;
  }

  public void reactToChange(PropertyChangeEvent event)
  {

    System.out.println("Notification on car : Light changed , New light ==>"+ event.getNewValue());
  }

}
