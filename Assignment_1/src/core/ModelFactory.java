package core;

import model.radiator.OffState;
import model.radiator.Radiator;
import model.radiator.RadiatorState;
import model.temperature.TemperatureModel;
import model.temperature.TemperatureModelManager;

public class ModelFactory
{
  private Radiator radiator;
  private TemperatureModel temperatureModel;

  public Radiator getRadiator()
  {
    if (radiator==null){
      radiator= new Radiator();
    }
    return radiator;
  }

  public TemperatureModel getTemperatureModel()
  {
    if (temperatureModel == null){
      temperatureModel= new TemperatureModelManager();
    }
    return temperatureModel;
  }
}
