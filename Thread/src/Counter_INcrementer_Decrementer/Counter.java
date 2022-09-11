package Counter_INcrementer_Decrementer;

public class Counter
{
  private long value;
  private long max;
  private long min;

  public Counter(long max, long min)
  {
    this.max = max;
    this.min = min;
    value=0;
  }
  public synchronized void increment()
  {

    if (value>=max)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
      }
    }
      value++;
      notifyAll();


  }
  public synchronized void decrement(){
    if (value<=min)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
      }
    }
      value--;
      notifyAll();

  }
  public long getValue(){
    return value;
  }
}
