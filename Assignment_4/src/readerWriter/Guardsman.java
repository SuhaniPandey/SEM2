package readerWriter;

import multiton.Valuables;

public class Guardsman implements TreasureRoomDoor
{
  private TreasureRoomDoor roomDoor;
  private int activeReader,activeWriter;


  @Override public void add(Valuables valuables)
  {
    roomDoor.add(valuables);
  }

  @Override public Valuables retrieve()
  {
    return roomDoor.retrieve();
  }

  @Override public void lookValuables()
  {

  }

  public synchronized void acquireRead(){
    while (activeWriter>0){
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    activeReader++;
  }
  public synchronized void releaseRead(){
    activeReader--;
    if (activeReader==0){
      notifyAll();
    }
  }

  public synchronized void acquireWrite(){
    while (activeReader>0 || activeWriter>0){
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    activeWriter++;
  }

  public synchronized void releaseWrite(){
    activeWriter--;
    if (activeWriter==0){
      notifyAll();
    }
  }
}
