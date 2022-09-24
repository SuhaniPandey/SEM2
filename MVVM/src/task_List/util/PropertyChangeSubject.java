package task_List.util;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject
{
   void addPropertyChangeListener(PropertyChangeListener listener);
   void removePropertyChangeListener(PropertyChangeListener listener);
  void addPropertyChangeListener(String eventName,PropertyChangeListener listener);
   void removePropertyChangeListener(String eventName,PropertyChangeListener listener);

}
