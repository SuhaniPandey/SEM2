package Counter_INcrementer_Decrementer;

public class CounterDecrementer implements Runnable
{

  private int update;
  private Counter counter;

  public CounterDecrementer(int update, Counter counter)
  {
    this.update = update;
    this.counter = counter;
  }

  @Override public void run()
  {
    for (int i = 0; i < update; i++)
    {
      counter.decrement();
      System.out.println(counter.getValue()+":"+Thread.currentThread().getName());

    }
    System.out.println(counter.getValue());


  }
}
