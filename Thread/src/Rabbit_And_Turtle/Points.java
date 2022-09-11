package Rabbit_And_Turtle;

public class Points
{
  private int RabbitPoint;
  private int TurtlePoint;

  public Points(int RabbitPoint, int TurtlePoint)
  {
    this.TurtlePoint=0;
    this.RabbitPoint=0;
  }

  private int increaseRabbitPoint(){
    return RabbitPoint++;
  }

  private int increaseTurtlePoint(){
    return TurtlePoint++;
  }

  private void counterRabbitPoint(){
    while (true)
    if (RabbitPoint >= 1000){
      System.out.println("Rabbit wins");
    }
  }


  private void counterTurtlePoint(){
    while (true)
    if (TurtlePoint <= 1000){
      System.out.println("Turtle wins");
    }
  }

  public int getTurtlePoint(){
    return TurtlePoint;
  }

  public int getRabbitPoint(){
    return RabbitPoint;
  }
}
