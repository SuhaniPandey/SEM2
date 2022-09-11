package Try_Lock_Counter;



public class Start
{
  public static void main(String[] args)
  {
    CounterIncrement counterIncrement= new CounterIncrement(new Counter());
    Thread firstthread= new Thread(counterIncrement);
    Thread secondthread = new Thread(counterIncrement);
    firstthread.start();
    secondthread.start();
  }
}
