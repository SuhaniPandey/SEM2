package readerPreference;

public class ReadersPreferenceReadWrite implements ReadWrite
{
  private int activeReader, waitingReader, writer;
  private int sharedData;

  public ReadersPreferenceReadWrite()
  {
    activeReader = 0;
    waitingReader = 0;
    writer = 0;
    sharedData = 0;
  }

  @Override public synchronized void acquireRead()
  {
    waitingReader++;
    while (writer>0){
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    waitingReader--;
    activeReader++;
  }

  @Override public synchronized void releaseRead()
  {
    activeReader--;
    if (activeReader==0){
      notifyAll();
    }
  }

  @Override public synchronized void acquireWrite()
  {
    while (activeReader>0 || writer>0 || waitingReader>0){
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    writer++;
  }

  @Override public synchronized void releasewrite()
  {
    writer--;
    notifyAll();
  }

  public void doWrite(){
    sharedData++;
  }

  public int doRead(){
    return sharedData;
  }
}
