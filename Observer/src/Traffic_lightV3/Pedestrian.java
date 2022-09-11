package Traffic_lightV3;

import Traffic_lightV2.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Pedestrian
{
  public Pedestrian(PropertyChangeSubject subject)
  {
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

    if (newValue.equals("GREEN")){
      System.out.println("Pedestrian waits");
    }
    else if (newValue.equals("YELLOW")){
      if (newValue.equals("RED")){
        System.out.println("pedestrian crosses the road");
      }
      else {
        System.out.println("Pedestrian runs faster across the road");
      }
    }
    else if (newValue.equals("RED")){
      System.out.println("Pedestrian crosses the road");
    }
  }
}
