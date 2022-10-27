package compresssion_strategy;

public class ZipCompression implements CompressionMethod
{
  @Override public String compress(String filename)
  {
    System.out.println(">----IT IS COMPRESSING THE FILE----<");
    System.out.println(filename+"-zip");
    return "";
  }
}
