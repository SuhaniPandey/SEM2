package UpdateSharedNumber;

public class StartClass
{
  public static void main(String[] args)
  {
    CountIncrementer count = new CountIncrementer(new Counter());
    Thread firstthread= new Thread(count);
    Thread secondthread = new Thread(count);
    firstthread.start();
    secondthread.start();

  }
}
