package robot;

import java.awt.geom.Point2D;

public class AggressiveBehaviour implements Behaviour
{
  @Override public int moveCommand(GameBoard board, Point2D robotLocation)
  {
    System.out.println("It is Agressive");
    return 1;
  }
}
