package Sleep;

public class Number implements Runnable
{

  @Override public void run()
  {
    for (int i = 0; i < 10; i++)
    {
      System.out.println(i);
      try{
        Thread.sleep(9000);
      }
      catch (InterruptedException e){
        System.out.println("...");
      }
    }

  }
}
