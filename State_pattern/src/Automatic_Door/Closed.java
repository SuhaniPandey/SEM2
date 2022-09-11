package Automatic_Door;

public class Closed implements DoorState
{
  @Override public void Open(Door door)
  {
    System.out.println("The door are closed");
    (new Thread(()->{
      try{
        Thread.sleep(10000);
        door.setDoorState(new Open());
      }
      catch (InterruptedException e){
        System.out.println("....");
      }
    })).start();

  }

  @Override public void Close(Door door)
  {
    System.out.println("The door are closed");
  }
}
