package Automatic_Door;

public class Opening implements DoorState
{

  @Override public void Open(Door door)
  {
    System.out.println("THe door are opening");
  }

  @Override public void Close(Door door)
  {
    System.out.println("The door are opening");
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
}
