package adapter;


//queue where producer add objects and consumer takes object
import multiton.Valuables;
import singleton.Log;
import utility.collection.ListADT;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Deposit implements ListADT<Valuables>
{
  private BlockingQueue<Valuables> valuables;
  private int capacity;
  private Log log;

  public Deposit(int capacity)
  {
    this.capacity=capacity;
    valuables=new ArrayBlockingQueue<Valuables>(capacity);
    log=Log.getInstance();
  }


  @Override public void add(int index, Valuables element)
  {

  }

  @Override public synchronized void add(Valuables element)
  {
    while (isFull()){
      try
      {
        wait();
        log.log("Miner is waiting as queue is full");
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    log.log("Valuable transporter is adding the valuables now");
    valuables.add(element);
    notifyAll();
  }

  @Override public synchronized Valuables remove(Valuables element)
  {
    while (isEmpty()){
      try
      {
        log.log("Valuable transporter is waiting as queue is empty");
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    log.log("Valuable transporter is removing the valuable as queue is full");
    Valuables result=valuables.remove();
    notifyAll();
    return result;
  }

  @Override public void set(int index, Valuables element)
  {

  }

  @Override public Valuables get(int index)
  {
    return null;
  }

  @Override public Valuables remove(int index)
  {
    return null;
  }



  @Override public int indexOf(Valuables element)
  {
    return 0;
  }

  @Override public boolean contains(Valuables element)
  {
    return false;
  }

  @Override public boolean isEmpty()
  {
    while (valuables.isEmpty()){
      return true;
    }
    return false;
  }

  @Override public boolean isFull()
  {
    while (valuables.size()>=capacity){
      return true;
    }
    return false;
  }

  @Override public int size()
  {
    return valuables.size();
  }

}
