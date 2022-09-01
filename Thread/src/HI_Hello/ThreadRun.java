package HI_Hello;

public class ThreadRun
{
  public static void main(String[] args)
  {
    Thread hiPrint = new Thread(new Hi());
    Thread helloPrint = new Thread(new Hello());
    hiPrint.start();
    helloPrint.start();
  }
}
