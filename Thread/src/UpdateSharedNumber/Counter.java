package UpdateSharedNumber;

public class Counter
{
  private int count;

  public Counter(){
    count=0;
  }

  public synchronized void increament(){

    count++;
  }

  public int getCount(){
    return count;
  }
}
