package log;

public class Test
{
  public static void main(String[] args)
  {
    LogLine logLine= new LogLine("sdf");

    LogLine logLine1= new LogLine("gdbefbv");
    LogLine logLine2= new LogLine("zscswdf");
   // Log log= Log.getInstance();
    LogMultiton logMultiton= LogMultiton.getInstance("File");
    logMultiton.addLog("sfsf");
    //log.addLog(logLine1.toString());

  }
}
