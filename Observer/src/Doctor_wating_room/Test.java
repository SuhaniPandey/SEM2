package Doctor_wating_room;

public class Test
{
  public static void main(String[] args) throws InterruptedException
  {
    WaitingRoom waitingRoom = new WaitingRoom();
    for (int i = 0; i < 20; i++)
    {
      Patient patient = new Patient(i, waitingRoom);
      Thread.sleep(1500);
    }

  }
}
