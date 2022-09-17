package Data_Representation;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class DataModel implements PropertyChangeSubject
{
  private int red, green, yellow;

  private Random random = new Random();
  private PropertyChangeSupport support;

  public DataModel() {
    support= new PropertyChangeSupport(this);
  }

  public void recalculateData() {
    int first = random.nextInt(100)+1;
    int second = random.nextInt(100)+1;
    int bottom = Math.min(first, second);
    int top = Math.max(first, second);

    red = bottom;
    green = top - bottom;
    yellow = 100 - top;
    System.out.println("red: " + red);
    support.firePropertyChange("RED",null,null);
    System.out.println("green: " + green);
    support.firePropertyChange("GREEN",null,null);
    System.out.println("yellow: " + yellow);
    support.firePropertyChange("YELLOW",null,null);
    System.out.println("Sum: " + (red + green + yellow)+"\n\n");
    support.firePropertyChange("SUM",null,null);
  }

  @Override public void addPropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName,listener);
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
   support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {
   support.removePropertyChangeListener(eventName,listener);
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
   support.removePropertyChangeListener(listener);
  }
}
