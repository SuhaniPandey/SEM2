package robot;

public class RobotTest
{
  public static void main(String[] args)
  {
    GameBoard gameBoard= new GameBoard();
    Robot robot= new Robot("Sida wala Bangu",gameBoard);
    robot.setBehaviourStrategy(new AggressiveBehaviour());
    robot.move();
  }
}
