package BearPokingManRun;

public class PokingMan implements Runnable
{
  private Thread bearThread;


  public PokingMan(Thread bearThread){
    this.bearThread = bearThread;

  }
  @Override public void run()
  {
    System.out.println("Man is walking");
    System.out.println("Man sees a bear");

    bearThread.interrupt();

    try
    {
      bearThread.join();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

    System.out.println("Dead");
  }
}
