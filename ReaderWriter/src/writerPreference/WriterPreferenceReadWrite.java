package writerPreference;

public class WriterPreferenceReadWrite implements ReadWrite
{
  private int readers, waitingWriters,activeWriters;
  private int sharedData;

  public WriterPreferenceReadWrite()
  {
    activeWriters = 0;
    waitingWriters = 0;
    readers = 0;
    sharedData = 0;
  }


  @Override public synchronized void acquireRead()
  {


      while (waitingWriters > 0 || activeWriters > 0 || readers > 5)
      {
        try
        {
          wait();
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
      readers++;


  }

  @Override public synchronized void releaseRead()
  {
    readers--;
    if (readers==0){
      notifyAll();
    }
  }

  @Override public synchronized void acquireWrite()
  {
    waitingWriters++;
    while (readers>0 || activeWriters>0){
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    waitingWriters--;
    activeWriters++;
  }

  @Override public synchronized void releasewrite()
  {
    activeWriters--;
    if (activeWriters==0){
      notifyAll();
    }
  }

  public void doWrite(){
    sharedData++;
  }

  public int doRead(){
    return sharedData;
  }

  public int getReaders()
  {
    return readers;
  }
}
