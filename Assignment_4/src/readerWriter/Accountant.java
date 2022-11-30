package readerWriter;

import singleton.Log;

public class Accountant implements Runnable
{
  private TreasureRoomDoor roomDoor;
  private Log log;

  public Accountant(TreasureRoomDoor roomDoor)
  {
    this.roomDoor = roomDoor;
    log=Log.getInstance();
  }

  @Override public void run()
  {
    while (true){
      roomDoor.acquireRead();
      roomDoor.lookValuables();
      log.log("\t\t\t\tAccountant is counting values of valuables--------");
      try
      {
        Thread.sleep(2000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      log.log("Accountant finished counting the valuables---woww");
      roomDoor.releaseRead();
      try
      {
        Thread.sleep(2000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
