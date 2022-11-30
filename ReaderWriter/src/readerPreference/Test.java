package readerPreference;

public class Test
{
  public static void main(String[] args)
  {
    ReadersPreferenceReadWrite rr= new ReadersPreferenceReadWrite();

    for (int i=0;i<5;i++)
    {
      new Thread(() ->{
      while (true) {
        rr.acquireRead();
        System.out.println("Reader reads: "+rr.doRead());
        rr.releaseRead();
        try
        {
          Thread.sleep(300);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
      }).start();
    }

    for (int i=0;i<2;i++)
    {
      new Thread(() ->{
        while (true) {
          rr.acquireWrite();
          rr.doWrite();
          System.out.println("Writer writes: "+rr.doRead());
          rr.releasewrite();
          try
          {
            Thread.sleep(250);
          }
          catch (InterruptedException e)
          {
            e.printStackTrace();
          }
        }
      }).start();
    }

  }
}
