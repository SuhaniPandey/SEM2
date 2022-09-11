package Rabbit_And_Turtle;

public class Turtle implements Runnable
{

  @Override public void run()
  {
    try
    {
      Thread.sleep(10);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
