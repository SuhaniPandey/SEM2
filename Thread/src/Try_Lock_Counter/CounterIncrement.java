package Try_Lock_Counter;

public class CounterIncrement implements Runnable
{
  private Counter counter;

  public CounterIncrement(Counter counter)
  {
    this.counter = counter;
  }

  @Override public void run()
  {
    for (int i = 0; i < 1000; i++)
    {
      counter.increment();
    }
    System.out.println(counter.getCount());
  }
}
