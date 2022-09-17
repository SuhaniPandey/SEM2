package Data_Representation;

public class Test
{
  public static void main(String[] args) throws InterruptedException
  {
    DataModel dataModel= new DataModel();
    while (true){
      dataModel.recalculateData();
      Thread.sleep(5000);
    }
  }
}
