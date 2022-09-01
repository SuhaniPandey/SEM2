package UpdateNumber;

public class Letter implements Runnable
{
  private int let;

  public Letter(int let){
    this.let=let;
  }

  @Override public void run()
  {
    for (int i = 0; i < let; i++)
    {
      System.out.println((char) (i+97));
    }
  }
}
