import adapter.Deposit;
import multiton.MIne;
import multiton.Valuables;
import producer_consumer.Miner;
import producer_consumer.ValuableTransporter;
import readerWriter.Accountant;
import readerWriter.King;
import readerWriter.TreasureRoom;
import readerWriter.TreasureRoomDoor;
import singleton.Log;

public class Test
{
  public static void main(String[] args)
  {
    Deposit deposit= new Deposit(10);
    TreasureRoomDoor roomDoor= new TreasureRoom();
    MIne mIne= new MIne();
    Miner miner= new Miner(deposit,mIne);
    Accountant accountant= new Accountant(roomDoor);
    ValuableTransporter transporter= new ValuableTransporter(deposit,roomDoor);
    King king= new King(roomDoor);
    new Thread(king).start();
    for (int i = 0; i < 2; i++)
    {
      new Thread(miner).start();
    }
    for (int i = 0; i < 2; i++)
    {
      new Thread(transporter).start();
    }

    for (int i = 0; i < 2; i++)
    {
      new Thread(accountant).start();
    }



  }
}
