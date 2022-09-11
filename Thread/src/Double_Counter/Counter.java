package Double_Counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter
{
  private int countA;
  private int countB;

  private Lock lockA = new ReentrantLock();
  private Lock lockB = new ReentrantLock();


  public Counter(int countA,int countB){
    this.countA=countA;
    this.countB=countB;
  }

  public  void increamentA(){
    synchronized (lockA){
      countA++;
    }

  }
  public  void increamentB(){
    synchronized (lockB){
      countB++;
    }

  }

  public int getCountA(){
    synchronized (lockA){
      return countA;
    }

  }

  public int getCountB(){
    synchronized (lockB){
      return countB;
    }

  }

}
