package queueContainingString;

import java.util.ArrayList;

public class Queue implements StringQueue
{
  private ArrayList<String> queue;
  private int capacity;


  public Queue(int cap){
    this.capacity=cap;
    queue= new ArrayList<>();
  }


  @Override public void enqueue(String element)
  {
   if (element ==null){
     throw  new IllegalArgumentException();
   }

   if (queue.size() == capacity){
     throw  new IllegalStateException();
   }

   queue.add(element);
  }

  @Override public String dequeue()
  {
    if (queue.isEmpty()){
      throw  new IllegalStateException();
    }
    queue.remove(0);
    return queue.get(0);
  }

  @Override public String first()
  {
    if (queue.isEmpty()){
      throw  new IllegalStateException();
    }
    return  queue.get(0);
  }

  @Override public int size()
  {
    return queue.size();
  }

  @Override public boolean isEmpty()
  {
    return queue.isEmpty();
  }

  @Override public int indexOf(String element)
  {
    if (queue.contains(element)){
      return queue.indexOf(element);
    }
    return -1;
  }

  @Override public boolean contains(String element)
  {
    return queue.contains(element);
  }
}
