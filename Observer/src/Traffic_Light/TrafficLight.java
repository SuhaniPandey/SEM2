package Traffic_Light;

import java.util.ArrayList;
import java.util.List;

public class TrafficLight
{
  List<Car> cars;
  List<Taxi> taxis;
  private int count = 2;
  private String[] lights = {"GREEN", "YELLOW", "RED", "YELLOW"};
  private String currentLight;

  public TrafficLight()
  {
    currentLight = lights[2];
    cars = new ArrayList<>();
  }
  public void addCar(Car car){
    cars.add(car);
    car.setLight(currentLight);
  }

  public void start() throws InterruptedException{
    for (int i = 0; i < 10; i++)
    {
      Thread.sleep(2000);
      count = (count+1)%4;
      currentLight = lights[count];
      System.out.println("\n Light is "+ currentLight);
      lightChanged();
    }
  }

  private void lightChanged(){
    for (Car car: cars){
      car.setLight(currentLight);
    }
  }
}