package Traffic_lightV2;

public class TestClass
{
  public static void main(String[] args) throws InterruptedException
  {
    TrafficLight trafficLight= new TrafficLight();
    Car car1= new Car();
    trafficLight.addPropertyChangeListener(car1);
    trafficLight.start();
  }
}
