package Traffic_lightV2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Pedestrian implements PropertyChangeListener
{

  public Pedestrian(){

  }
  @Override public void propertyChange(PropertyChangeEvent evt)
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
