package Traffic_lightV2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Taxi implements PropertyChangeListener
{
  public Taxi(){

  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    String oldValue = (String) evt.getOldValue();
    String newValue = (String) evt.getNewValue();

    if (newValue.equals("GREEN"))
    {
      System.out.println("Taxi drives");
    }

    else if (newValue.equals("RED"))
    {
      System.out.println("Taxi stops");
    }

  }
}
