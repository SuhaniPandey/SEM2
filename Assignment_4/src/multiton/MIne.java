package multiton;

import java.util.Random;

public class MIne
{

  private Valuables valuables;


  public Valuables getAllValuables(){
    Random random= new Random();
    int value= random.nextInt(0,60);
    if (value<10){
      return Valuables.getInstance("Diamond");
    }
    else if (value<30){
      return Valuables.getInstance("Gold");
    }
    else if (value<60){
      return Valuables.getInstance("Silver");
    }
    else {
      return Valuables.getInstance("YOu got nothing");
    }
  }
}
