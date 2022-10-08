package Temperature.core;

import Temperature.mediator.TemperatureModel;

public class ModelFactory
{
  private TemperatureModel model;

  public ModelFactory(TemperatureModel model)
  {
    this.model = model;
  }

  public TemperatureModel getTemperatureModel()
  {
    return model;
  }
}
