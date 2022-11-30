package readerWriter;

import multiton.Valuables;
import singleton.Log;

import java.util.ArrayList;
import java.util.Random;

public class King implements Runnable
{
  private TreasureRoomDoor roomDoor;
  private ArrayList<Valuables> valuablesArrayList;
  private Log log;

  public King(TreasureRoomDoor roomDoor)
  {
    this.roomDoor = roomDoor;
    valuablesArrayList = new ArrayList<>();
    log=Log.getInstance();
  }

  @Override public void run()
  {
    while (true){
      double random=new Random().nextInt(50,100);
      roomDoor.acquireWrite();
      Valuables valuables=roomDoor.retrieve();
      valuablesArrayList.add(valuables);
      roomDoor.lookValuables();

      double value= valuables.getValue();
      if (!(value>=random)){
        log.log("King cannot throw the party now----");

        for (Valuables valuables1 : valuablesArrayList)
        {
          roomDoor.add(valuables1);//put the valuable back to treasure room
        }
        try
        {
          Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
        log.log("released write by king");
        roomDoor.releaseWrite();
        break;
      }
      else if (value>=random){
        log.log("King is gonna throw the party----");
        valuablesArrayList.clear(); //throw away all the retrieve valuables
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
}
