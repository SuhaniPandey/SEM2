package Traffic_lightV3;

import Traffic_lightV2.Pedestrian;
import Traffic_lightV2.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Car
{

  public Car(PropertyChangeSubject subject){

    PropertyChangeListener listener = new PropertyChangeListener()
    {
      @Override public void propertyChange(PropertyChangeEvent evt)
      {
        reactToChange(evt);
      }
    };
    subject.addPropertyChangeListener(listener);
  }

   public void reactToChange(PropertyChangeEvent evt)
  {
    String oldValue = (String) evt.getOldValue();
    String newValue = (String) evt.getNewValue();

    if (newValue.equals("GREEN"))
    {
      System.out.println("Car  drives");
    }
    else if (newValue.equals("YELLOW"))
    {
      if (newValue.equals("RED"))
      {
        System.out.println("Car turns engine on");
      }
      else
      {
        System.out.println("Car slows down");
      }
    }
    else if (newValue.equals("RED"))
    {
      System.out.println("Car stops");
    }
  }
}
