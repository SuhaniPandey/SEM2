package log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LogMultiton
{
  private static Log instance;
  private String fileName;
  private ArrayList<LogLine> logLines;

  private static Map<String, LogMultiton> map = new HashMap<>();


  public LogMultiton(String fileName)
  {
    logLines= new ArrayList<>();
    this.fileName= fileName;
  }

  public static LogMultiton getInstance(String fileName)
  {
    LogMultiton instance=map.get(fileName);
    if (instance== null){
      synchronized (map){
        instance= map.get(fileName);
        if (instance== null)
        {
          instance = new LogMultiton(fileName);
          map.put(fileName,instance);
        }
      }
    }
    return instance;
  }

  public void addLog(String log){
    LogMultiton logMultiton= new LogMultiton(log);
    LogLine logLine= new LogLine(log);
    logLines.add(logLine);
    addToFile(logLine );
  }

  public Map<String, LogMultiton> getAll(){
    return map;
  }

  @Override public String toString()
  {
    return "LogMultiton{" + "fileName='" + fileName + '\'' + '}';
  }

  private void addToFile(LogLine log)
  {
    if (log == null)
    {
      return;
    }
    BufferedWriter out = null;
    try
    {
      out = new BufferedWriter(new FileWriter(fileName, true));
      out.write(log + "\n");
    }
    catch (Exception e) {e.printStackTrace();}
    finally
    {
      try
      {
        out.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }

}
