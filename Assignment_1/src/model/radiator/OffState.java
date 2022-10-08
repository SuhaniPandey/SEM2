package model.radiator;

public class OffState implements RadiatorState
{
  private static int POWER=0;

  @Override public void turnUp(Radiator radiator)
  {
    radiator.setPowerState(new Power1State());
  }

  @Override public void turnDown(Radiator radiator)
  {
    //radiator.getPower();
    System.out.println("this is minimum power you can decrease");
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
