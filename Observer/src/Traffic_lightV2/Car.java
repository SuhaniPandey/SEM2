package Traffic_lightV2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Car implements PropertyChangeListener
{


  public Car(){

  }

  @Override public void propertyChange(PropertyChangeEvent evt)
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

