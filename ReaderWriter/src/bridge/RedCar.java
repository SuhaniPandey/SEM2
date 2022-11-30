package bridge;

public class RedCar implements Runnable

{
  private Bridge bridge;

  public RedCar(Bridge bridge) {
    this.bridge = bridge;
  }

  @Override
  public void run() {
    while (true) {
      bridge.enterFromLeft();
      System.out.println("Red car on bridge");
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bridge.exitFromLeft();
      System.out.println("Red car left bridge");
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
