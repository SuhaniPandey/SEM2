package robot;

import java.awt.geom.Point2D;

public class DefensiveBehaviour implements Behaviour
{
  @Override public int moveCommand(GameBoard board, Point2D robotLocation)
  {
    System.out.println("It is Defensive");
    return 0;
  }
}
