package UpdateNumber;

public class ThreadClass
{
  public static void main(String[] args)
  {
    Thread numPrint = new Thread(new Number(57));
    Thread letPrint = new Thread(new Letter(33));
    numPrint.start();
    letPrint.start();
  }
}
