package compresssion_strategy;

import javax.swing.*;
import java.util.List;

public class Compressor
{
  private CompressionMethod method;

  public void setMethod(CompressionMethod method)
  {
    this.method = method;
  }

  public void compress(List<String> files){
    for (int i = 0; i < files.size(); i++)
    {
      method.compress(files.get(i));
    }
  }
}
