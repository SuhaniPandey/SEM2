package Traffic_lightV3;

import Traffic_lightV2.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Taxi
{
  public Taxi(PropertyChangeSubject subject)
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
