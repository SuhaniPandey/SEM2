package UpdateSharedNumber;

public class Counter
{
  private int count;

  public Counter(){
    count=0;
  }

  public int increament(){

    return count++;
  }

  public int getCount(){
    return count;
  }
}
