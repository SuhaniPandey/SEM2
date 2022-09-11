package Program;

public class MailBox implements Runnable
{
  private long maxFrequency;
  private int count;
  private static long RUNTIME = 100000;

  public MailBox(int count)
  {
    this.count = count;
  }

  private void waitingForMails()
  {

  }

  @Override public void run()
  {
    for (int i = 0; i < count; i++)
    {
      System.out.println("New mail is in your mailbox");

    }

  }
}
