package UpdateSharedNumber;

public class CountIncrementer implements Runnable
{
  private Counter counter;

  public CountIncrementer(Counter counter){
    this.counter=counter;
  }
  @Override public void run()
  {
    for (int i = 0; i < 1000; i++)
    {
      counter.increament();
    }
    System.out.println(counter.getCount());
  }
}
