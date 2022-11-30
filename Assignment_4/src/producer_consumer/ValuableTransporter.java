package producer_consumer;

import adapter.Deposit;
import multiton.Valuables;
import readerWriter.TreasureRoom;
import readerWriter.TreasureRoomDoor;
import singleton.Log;

import java.util.ArrayList;
import java.util.Random;

//consumer
public class ValuableTransporter implements Runnable
{

  private Deposit deposit;
  private ArrayList<Valuables> valuables;
  private Log log;
  private TreasureRoomDoor roomDoor;

  public ValuableTransporter(Deposit deposit, TreasureRoomDoor roomDoor)
  {
    this.deposit = deposit;
    this.roomDoor=roomDoor;
    log= Log.getInstance();
    valuables= new ArrayList<>();
  }

  @Override public void run()
  {
    while (true){
     int randomNumber= new Random().nextInt(50,200);
     while (randomNumber>= valuables.size()){
       Valuables valuable= deposit.get(0);
       log.log("adding valuables to the transport to treasure room");
       valuables.add(valuable);
     }
     log.log("Target reached...");
     log.log("Going to treasure room");
     valuables.clear();
      try
      {
        Thread.sleep(20000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      log.log("back from treasure room");
      roomDoor.acquireWrite();
      for (int i = 0; i < valuables.size(); i++)
      {
        Valuables valuable=null;
        try
        {
          Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
        valuables.add(valuable);
      }
      roomDoor.releaseWrite();
    }

  }
}
