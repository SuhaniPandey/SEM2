package Radiator_Ex;

public class OffState implements RadiatorState
{
  private static int POWER=0;

  @Override public void turnUp(Radiator radiator)
  {
    radiator.setPowerState(new Power1State());
  }

  @Override public void turnDown(Radiator radiator)
  {
    radiator.getPower();
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
