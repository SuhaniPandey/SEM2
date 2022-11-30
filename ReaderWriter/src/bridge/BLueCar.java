package bridge;

public class BLueCar implements Runnable
{

  public Bridge bridge;

  public BLueCar(Bridge bridge) {
    this.bridge = bridge;
  }

  @Override public void run()
  {
    while (true) {
      bridge.enterFromRight();
      System.out.println("Blue car on bridge");
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bridge.exitFromLeft();
      System.out.println("Blue car left bridge");
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
