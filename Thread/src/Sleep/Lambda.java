package Sleep;

public class Lambda
{
  public static void main(String[] args)
  {
    (new Thread(()->{
      for (int i = 0; i < 10; i++)
      {
        System.out.println(i);
        try{
          Thread.sleep(1000);
        }
        catch (InterruptedException e){
          System.out.println("....");
        }
      }
    })).start();

  }
}
