package toilet;

public class ToiletBuilding implements PublicToilet
{
  private int waitingPerson, personInCabin, cleaningPerson;
  private int capacityOfCabin;

  public ToiletBuilding(int capacityOfCabin)
  {
    waitingPerson = 0;
    personInCabin = 0;
    cleaningPerson = 0;
    this.capacityOfCabin=capacityOfCabin;
  }

  @Override public synchronized void stepIntoCabin()
  {
    waitingPerson++;
    while (personInCabin==capacityOfCabin || cleaningPerson>0){
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    waitingPerson--;
    personInCabin++;
  }

  @Override public synchronized void leaveCabin()
  {
    personInCabin--;
    notifyAll();
  }

  @Override public synchronized void startCleaning()
  {
    while (personInCabin>0){
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    personInCabin--;
      cleaningPerson++;

  }

  @Override public synchronized void endCleaning()
  {
    cleaningPerson--;
    notifyAll();
  }
}
