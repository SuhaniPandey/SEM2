package queueContainingString;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class QueueTest
{
  private Queue queue;

  @org.junit.Before public void setUp() throws Exception
  {
    queue= new Queue(6);
  }


  @org.junit.Test (expected = IllegalStateException.class)
  public void enqueue()
  {
    queue.enqueue("w");
    queue.enqueue("e");
    queue.enqueue("f");
    queue.enqueue("g");
    queue.enqueue("t");
  }

  @Test (expected = IllegalStateException.class)
  public void dequeue()
  {
    queue.dequeue();
    queue.dequeue();
  }

  @Test(expected = IllegalStateException.class)
  public void first()
  {
    queue.first();
  }

  @Test public void size()
  {
    queue.enqueue("w");
    assertEquals(1,queue.size());
  }

  @Test public void isEmpty()
  {
    assertEquals(true,queue.isEmpty());
  }

  @Test public void indexOf()
  {
    queue.enqueue("w");
    queue.enqueue("e");
    queue.enqueue("f");
    queue.enqueue("g");
    queue.enqueue("t");
    assertEquals(-1,queue.indexOf("k"));
  }

  @Test public void contains()
  {
    queue.enqueue("w");
    queue.enqueue("e");
    queue.enqueue("f");
    queue.enqueue("g");
    queue.enqueue("t");
    assertEquals(false,queue.contains("j"));
  }
}