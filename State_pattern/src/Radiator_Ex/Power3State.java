package Radiator_Ex;

public class Power3State implements RadiatorState
{
  private static int POWER = 3;
  private Thread thread;

  public Power3State(Radiator radiator)
  {
     thread= new Thread (()->{
      try{
        Thread.sleep(3000);
        radiator.setPowerState(new Power2State());
        System.out.println("Changed to power 2 state");
      }
      catch (InterruptedException e){
        System.out.println("....");
      }
    });
    thread.setDaemon(true);
    thread.start();
  }

  @Override public void turnUp(Radiator radiator)
  {
    //nothing happens
  }

  @Override public void turnDown(Radiator radiator)
  {
    thread.interrupt();
    radiator.setPowerState(new Power2State());
  }

  @Override public int getPower()
  {
    return POWER;
  }


}
