package blockingQueue;

import utility.collection.BoundedArrayQueue;
import utility.collection.QueueADT;

public class BlockingQueue<T> implements Buffer<T>
{
  private QueueADT<T> queueADT;

  public BlockingQueue(int capacity){
    this.queueADT= new BoundedArrayQueue<>(capacity);
  }

  @Override public synchronized void put(T element)
  {
    while (queueADT.isFull()){
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    queueADT.enqueue(element);
    notifyAll();
  }

  @Override public synchronized T take()
  {
    while (queueADT.isEmpty()){
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    T result = queueADT.dequeue();
    notifyAll();
    return result;
  }

  @Override public synchronized T look()
  {
    if (queueADT.isEmpty()){
      return null;
    }
    return queueADT.first();
  }

  @Override public boolean isEmpty()
  {
    if (queueADT.isEmpty()){
      return true;
    }
    return false;
  }

  @Override public boolean isFull()
  {
    if (queueADT.isFull()){
      return true;
    }
    return false;
  }

  @Override public int size()
  {
    return queueADT.size();
  }
}
