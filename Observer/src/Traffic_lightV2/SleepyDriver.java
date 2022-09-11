package Traffic_lightV2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SleepyDriver implements PropertyChangeListener
{

  public SleepyDriver()
  {
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    String oldValue = (String) evt.getOldValue();
    String newValue = (String) evt.getNewValue();

    if (newValue.equals("GREEN")){
      System.out.println("Sleepy driver starts engines and drive");
    }
    else if (newValue.equals("YELLOW")){
      if (newValue.equals("RED")){
        System.out.println("Sleepy driver doesn't do anything");
      }
      else {
        System.out.println("Sleepy driver slows down");
      }
    }
    else if (newValue.equals("RED")){
      System.out.println("Sleepy driver stops");
    }
  }
}
