package multiton;

import java.util.HashMap;
import java.util.Map;

public class Valuables
{
  private static Map<String,Valuables> allInstances=new HashMap<>();

  private Valuables()
  {

  }

  public static Valuables getInstance(String key){
    Valuables instance= allInstances.get(key);
    if (instance == null)
    {
      instance = new Valuables();
      allInstances.put(key,instance);
    }
    return instance;
  }

  public int getValue()
  {
    if (allInstances.containsKey("Diamond")){
      return 100;
    }
    else if (allInstances.containsKey("Gold")){
      return 60;
    }
    else if (allInstances.containsKey("Silver")){
      return 30;
    }
    return 0;
  }
}
