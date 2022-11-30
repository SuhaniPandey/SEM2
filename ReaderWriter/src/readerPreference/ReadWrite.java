package readerPreference;

public interface ReadWrite
{
  void acquireRead();
  void releaseRead();
  void acquireWrite();
  void releasewrite();
}
