package singleton;

public class Log
{
  private static Log instance;

  private Log(){

  }


  public static Log getInstance(){
    if (instance==null){
      instance=new Log();
    }
    return instance;
  }

  public void log(String text){
    System.out.println(text);
  }
  {
  }
}
