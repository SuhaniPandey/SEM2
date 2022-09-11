package BIrd_Watching;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Random;

public class Bird implements PropertyChangeSubject
{
  PropertyChangeSupport support= new PropertyChangeSupport(this);
  private String[] action= {"flashes its wing","whistles","Sings voice"};
  public Bird()
  {
    this.support = support;
  }

  public void action() throws InterruptedException
  {
    for (int i = 0; i < 10; i++)
    {
     Thread.sleep(2000);
      Random random = new Random();
      int randomNumber= (random.nextInt(0,3));
      System.out.println("Peacock "+action[randomNumber]);
      support.firePropertyChange("Peacock",null,action[randomNumber]);
    }
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
