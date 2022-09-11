package Rabbit_And_Turtle;

import java.util.Random;

public class Rabbit implements Runnable
{
  private Turtle turtle;
  private Points points;

  public Rabbit(Points points,Turtle turtle){
    this.points=points;
    this.turtle=turtle;
  }

  public void rabbitSleep(){
    while (points.getRabbitPoint()- points.getTurtlePoint()==50){
      Random random = new Random();

    }
    {
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }


  @Override public void run()
  {


  }
}
