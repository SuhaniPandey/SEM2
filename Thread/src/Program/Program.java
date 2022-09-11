package Program;

public class Program implements Runnable
{
  private String program;
  private long maxFrequency;
  private String action;
  private int count;
  private static long RUNTIME=100000;

  public Program(String program, String action, int count)
  {
    this.program = program;
    this.action = action;
    this.count = count;
  }

  private void normalOperation(){

  }
  @Override public void run()
  {
    for (int i = 0; i < count; i++)
    {
      try
      {
        System.out.println(program+" wants to "+action);
        Thread.sleep(RUNTIME/30);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

  }
}
