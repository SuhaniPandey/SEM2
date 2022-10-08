package Temperature.core;

import Temperature.view.TemperatureViewModel;

public class ViewModelFactory
{

  private ModelFactory modelFactory;
  private TemperatureViewModel temperatureViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public TemperatureViewModel getTemperatureViewModel()
  {
    return temperatureViewModel;
  }
}
