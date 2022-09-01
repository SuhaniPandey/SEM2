package BearPokingManRun;

public class Bear implements Runnable
{
  @Override public void run()
  {
    System.out.println("Bear is feeling tired");
    System.out.println("Bear goes to sleep");
    Thread bear1 = new Thread();
    Thread bear2 = new Thread();
    Thread bear3 = new Thread();
    Thread bear4 = new Thread();
    try
    {
      Thread.sleep(1000);
      System.out.println("Happy bear");
    }
    catch (InterruptedException e)
    {
      System.out.println("Angry Bear");

      bear1.interrupt();
      System.out.println("second bear wakes up");
      bear2.interrupt();
      System.out.println("third bear wakes up");
      bear3.interrupt();
      System.out.println("fourth bear wakes up");
      bear4.interrupt();
      System.out.println("Fifth bear wakes up");
    }
  }
}
