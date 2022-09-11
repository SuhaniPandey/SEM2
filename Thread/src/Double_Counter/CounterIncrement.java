package Double_Counter;

public class CounterIncrement implements Runnable
{
  private Counter counter;

 public void run()
  {
    for (int i = 0; i < 1000; i++)
    {
      counter.increamentA();
      counter.increamentB();
    }
    System.out.println(counter.getCountA());
    System.out.println(counter.getCountB());
  }
}
