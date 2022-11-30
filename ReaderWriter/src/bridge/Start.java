package bridge;

public class Start
{
  public static void main(String[] args)
  {
    Bridge bridge = new Bridge();
    for (int i = 0; i < 10; i++) {
      new Thread(new BLueCar(bridge)).start();
    }
    for (int i = 0; i < 10 ; i++) {
      new Thread(new RedCar(bridge)).start();
    }
  }
}
