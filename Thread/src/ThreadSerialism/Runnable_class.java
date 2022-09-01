package ThreadSerialism;

public class Runnable_class implements Runnable
{
  private int x;
  private int y;

  public Runnable_class(int x,int y){
    this.x=x;
    this.y=y;
  }
  @Override public void run()
  {
    for (int i = x; i < y; i++)
    {
      System.out.println(i);
    }
  }
}
