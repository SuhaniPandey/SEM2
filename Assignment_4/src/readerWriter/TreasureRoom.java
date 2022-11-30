package readerWriter;

import multiton.Valuables;
import singleton.Log;

import java.util.ArrayList;
import java.util.List;

public class TreasureRoom implements TreasureRoomDoor
{

  private List<Valuables> valuablesList;

  private Log log;

  public TreasureRoom()
  {
    valuablesList = new ArrayList<>();
    log = Log.getInstance();
  }

  @Override public void add(Valuables valuables)
  {
    valuablesList.add(valuables);
  }

  @Override public Valuables retrieve()
  {
    if (valuablesList.isEmpty())
    {
      log.log("the valuables are none....");
    }
    return valuablesList.get(0);
  }

  @Override public void lookValuables()
  {
    int values = 0;
    for (Valuables valuables : valuablesList)
    {
      values += valuables.getValue();
      log.log("total values of valuables: "+values);
    }
  }

  @Override public void releaseWrite()
  {

  }

  @Override public void releaseRead()
  {

  }

  @Override public void acquireWrite()
  {

  }

  @Override public void acquireRead()
  {

  }

}
