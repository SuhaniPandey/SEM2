package Sleep;

public class StartThread
{
  public static void main(String[] args)
  {
    Thread num = new Thread(new Number());
    num.start();
  }
}
