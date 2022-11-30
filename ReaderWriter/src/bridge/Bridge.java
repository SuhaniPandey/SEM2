package bridge;

public class Bridge implements Lane

{
  private int carsMovingInLeft, carsMovingInRight;
  private int carEnteringFromLeft;
  private int carsEnteringFromRight;

  public Bridge()
  {
    carEnteringFromLeft=0;
    carsEnteringFromRight=0;
    carsMovingInRight=0;
    carsMovingInLeft=0;
  }

  @Override public synchronized void enterFromLeft()
  {

  }

  @Override public synchronized void enterFromRight()
  {

  }

  @Override public synchronized void exitFromLeft()
  {
    carsMovingInLeft--;
    notifyAll();
  }

  @Override public synchronized void exitFromRight()
  {
    carsMovingInRight--;
    notifyAll();
  }
}
