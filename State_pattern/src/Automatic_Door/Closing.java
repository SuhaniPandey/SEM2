package Automatic_Door;

public class Closing implements DoorState
{
  @Override public void Open(Door door)
  {
    System.out.println("The doors are closed");
    (new Thread(()->{
      try{
        Thread.sleep(10000);
      }
      catch (InterruptedException e){
        System.out.println("....");
      }
    })).start();
    door.setDoorState(new Open());
    System.out.println("The doors are opening");
  }

  @Override public void Close(Door door)
  {
    door.setDoorState(new Closed());
    System.out.println("The door are closing");
  }
}
