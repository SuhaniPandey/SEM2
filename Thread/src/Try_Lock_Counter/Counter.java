package Try_Lock_Counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter
{
  private int count;
  private Lock reentrantLock = new ReentrantLock();

  public Counter()
  {
    count=0;
  }

  public void increment(){

    if (reentrantLock.tryLock()){
      count++;
      reentrantLock.unlock();
    }else
    {
      System.out.println("Lock was in use");
    }
  }

  public synchronized  int getCount(){
    return count;
  }
}
