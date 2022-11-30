package readerWriter;

import multiton.Valuables;

public interface TreasureRoomDoor
{
  void add(Valuables valuables);
  Valuables retrieve();
  void lookValuables();

  void releaseWrite();
  void releaseRead();
  void acquireWrite();
  void acquireRead();
}
