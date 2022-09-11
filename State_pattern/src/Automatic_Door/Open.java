package Automatic_Door;

public class Open implements DoorState
{
  @Override public void Open(Door door)
  {
    System.out.println("The door is Open");
  }

  @Override public void Close(Door door)
  {
    System.out.println("The door are opened");
    (new Thread(()->{
      try{
        Thread.sleep(10000);
        door.setDoorState(new Closed());
        System.out.println("The door are closing");
      }
      catch (InterruptedException e){
        System.out.println("....");
      }
    })).start();

  }
}
