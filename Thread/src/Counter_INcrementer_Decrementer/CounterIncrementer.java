package Counter_INcrementer_Decrementer;

public class CounterIncrementer implements Runnable
{
  private int updates;
  private Counter counter;

  public CounterIncrementer(int updates, Counter counter)
  {
    this.updates = updates;
    this.counter = counter;
  }

  @Override public void run()
  {
    for (int i = 0; i < updates; i++)
    {
      counter.increment();
      System.out.println(counter.getValue()+":"+Thread.currentThread().getName());

    }
    System.out.println(counter.getValue());

  }
}
