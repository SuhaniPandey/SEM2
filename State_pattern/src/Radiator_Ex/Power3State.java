package Radiator_Ex;

public class Power3State implements RadiatorState
{
  private static int POWER = 3;

  @Override public void turnUp(Radiator radiator)
  {

  }

  @Override public void turnDown(Radiator radiator)
  {

  }

  @Override public int getPower()
  {
    return POWER;
  }
}
