package Traffic_Light;

public class Taxi
{
   private int id;
   private String previousLight;

  public Taxi(int id)
  {
    this.id = id;
  }


  public void setLight(String currentLight){
    if ("GREEN".equals(currentLight))
    {
      System.out.println("Taxi"+ id + "drives");
    }

    else if ("RED".equals(currentLight))
    {
      System.out.println("Taxi"+id + "stops");
    }
  }


}
