package model.temperature;

import util.NamedPropertyChangeSubject;

public interface TemperatureModel extends NamedPropertyChangeSubject
{
  void addTemperature(String id, double temperature);

  Temperature getLastInsertedTemperature();

  Temperature getLastInsertedTemperature(String id);

  void addOutDoorTemp(String id, double value);
}
