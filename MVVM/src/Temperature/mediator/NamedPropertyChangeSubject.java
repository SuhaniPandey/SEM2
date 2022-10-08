package Temperature.mediator;

import java.beans.PropertyChangeListener;

public interface NamedPropertyChangeSubject
{
  void addListener(String propertName, PropertyChangeListener listener);
  void removeListerner(String propertyName,PropertyChangeListener listener);
}
