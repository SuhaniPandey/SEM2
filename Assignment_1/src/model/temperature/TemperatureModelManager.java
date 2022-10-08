package model.temperature;



import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel
{
  private TemperatureList temperatureList;
  private PropertyChangeSupport support;

  public TemperatureModelManager()
  {
    temperatureList = new TemperatureList();
    support= new PropertyChangeSupport(this);
  }

  @Override public void addTemperature(String id, double value)
  {
    Temperature temperature = new Temperature(id, value);
    Temperature old = getLastInsertedTemperature();
    this.temperatureList.addTemperature(temperature);
    support.firePropertyChange("TemperatureAdded",old,temperature);
    if (old != null && old.getValue() != temperature.getValue())
    {
      System.out.println("-->" + temperature + " (from: " + old + ")");
    }

  }

  @Override public Temperature getLastInsertedTemperature()
  {
    return temperatureList.getLastTemperature(null);
  }

  @Override public Temperature getLastInsertedTemperature(String id)
  {
    return temperatureList.getLastTemperature(id);
  }

  @Override public void addOutDoorTemp(String id, double value)
  {
    Temperature temperature= new Temperature(id,value);
    support.firePropertyChange("OutsideTemperature",null,temperature);

  }

  public void addListener(String propertName,
      PropertyChangeListener listener)
  {
    if (propertName== null){
      support.addPropertyChangeListener(listener);
    }
    support.addPropertyChangeListener(propertName, listener);
  }

   public void removeListerner(String propertyName,
      PropertyChangeListener listener)
  {
    if (propertyName== null){
      support.removePropertyChangeListener(listener);
    }
    support.removePropertyChangeListener(propertyName, listener);
  }

}
