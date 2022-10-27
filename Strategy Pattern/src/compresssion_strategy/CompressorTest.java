package compresssion_strategy;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompressorTest
{
  public static void main(String[] args)
  {
    Compressor compressor= new Compressor();
    compressor.setMethod(new ZipCompression());

    List<String> list= new ArrayList<>(Arrays.asList("1","2","3"));
    compressor.compress(list);
  }
}
