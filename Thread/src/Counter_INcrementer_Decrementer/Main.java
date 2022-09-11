package Counter_INcrementer_Decrementer;

public class Main
{
  public static void main(String[] args)
  {
    Counter counter= new Counter(20,1);
    CounterIncrementer counterIncrementer= new CounterIncrementer(200,counter);
    CounterIncrementer counterIncrementer1= new CounterIncrementer(200,counter);
    CounterDecrementer counterDecrementer= new CounterDecrementer(200,counter);
    CounterDecrementer counterDecrementer1= new CounterDecrementer(200,counter);
    Thread thread1= new Thread(counterIncrementer);
    Thread thread12= new Thread(counterIncrementer1);
    Thread thread3= new Thread(counterDecrementer);
    Thread thread4= new Thread(counterDecrementer1);
    thread1.start();
    thread12.start();
    thread3.start();
    thread4.start();
  }
}
