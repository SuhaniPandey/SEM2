package BIrd_Watching;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Bird_Watcher implements PropertyChangeListener
{

  public Bird_Watcher(Bird bird){
    bird.addPropertyChangeListener("Peacock", this);
  }
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    String newValue = (String) evt.getNewValue();
    if (newValue.equals("flashes its wing")){
      System.out.println("woww..........");
    }
    else if (newValue.equals("whistles")){
      System.out.println("What a sweet voice......");
    }
    else if (newValue.equals("Sings voice")){
      System.out.println("I wanna hear it again");
    }

  }
}
