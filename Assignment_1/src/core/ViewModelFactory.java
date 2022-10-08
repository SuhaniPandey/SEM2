package core;

import view.radiator.RadiatorViewModel;
import view.temperature.TemperatureViewModel;

public class ViewModelFactory
{

  private ModelFactory modelFactory;
  private RadiatorViewModel radiatorViewModel;
  private TemperatureViewModel temperatureViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory=modelFactory;
  }

  public RadiatorViewModel getRadiatorViewModel(){
    if (radiatorViewModel ==null){
      radiatorViewModel= new RadiatorViewModel(modelFactory.getRadiator());
    }
    return radiatorViewModel;
  }

  public TemperatureViewModel temperatureViewModel(){
    if (temperatureViewModel== null){
      temperatureViewModel= new TemperatureViewModel(modelFactory);
    }
    return temperatureViewModel;
  }
}
