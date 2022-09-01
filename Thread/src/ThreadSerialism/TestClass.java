package ThreadSerialism;

public class TestClass
{
  public static void main(String[] args) throws InterruptedException
  {
    Runnable_class run1= new Runnable_class(0,25);
    Runnable_class run2 = new Runnable_class(26,50);
    Runnable_class run3= new Runnable_class(52,75);
    Thread first = new Thread(run1);
    Thread second = new Thread(run2);
    Thread third =  new Thread(run3);
    first.start();
    first.join();
    second.start();
    second.join();
    third.start();
    third.join();
  }
}
