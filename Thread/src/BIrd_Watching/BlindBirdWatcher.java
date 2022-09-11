package BIrd_Watching;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BlindBirdWatcher implements PropertyChangeListener
{
  public BlindBirdWatcher(Bird bird){
    bird.addPropertyChangeListener("Peacock", this);
  }
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    String oldValue = (String) evt.getOldValue();
    String newValue = (String) evt.getNewValue();

    if (newValue.equals("Peacock flap its wing")){
      System.out.println("I am blind..I cant see");
    }
    else if (newValue.equals("Peacock whistles")){
      System.out.println("I can hear even if i am blind...what a sweet voice!");
    }
  }
}
