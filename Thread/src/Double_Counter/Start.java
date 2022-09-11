package Double_Counter;

import UpdateSharedNumber.CountIncrementer;
import UpdateSharedNumber.Counter;

public class Start
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
