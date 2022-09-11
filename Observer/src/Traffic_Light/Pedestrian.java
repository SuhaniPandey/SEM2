package Traffic_Light;

public class Pedestrian
{
  private String previousLight;

  public void setLight(String currentLight)
  {
    if ("GREEN".equals(currentLight)){
      System.out.println("Pedestrian waits");
    }
    else if ("YELLOW".equals(currentLight)){
      if ("RED".equals(previousLight)){
        System.out.println("pedestrian crosses the road");
      }
      else {
        System.out.println("Pedestrian runs faster across the road");
      }
    }
    else if ("RED".equals(currentLight)){
      System.out.println("Pedestrian crosses the road");
    }
  }
}
