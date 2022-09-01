package UpdateNumber;

public class Number implements Runnable
{
  private int num;

  public Number(int num){
    this.num= num;
  }

  @Override public void run()
  {
    for (int i = 0; i < num; i++)
    {
      System.out.println(i);
    }
  }
}
