package Traffic_Light;

public class SleepyDriver
{
  private String previousLight;
  private int id;

  public SleepyDriver(int id)
  {
    this.id = id;
  }

  public void setLight(String currentLight)
  {
    if ("GREEN".equals(currentLight)){
      System.out.println("Sleepy driver"+id+"starts engines and drive");
    }
    else if ("YELLOW".equals(currentLight)){
       if ("RED".equals(previousLight)){
         System.out.println("Sleepy driver"+id+"doesn't do anything");
       }
       else {
         System.out.println("Sleepy driver"+id+"slows down");
       }
    }
    else if ("RED".equals(currentLight)){
      System.out.println("Sleepy driver"+id+"stops");
    }
  }
}
