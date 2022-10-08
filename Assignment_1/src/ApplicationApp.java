import core.ModelFactory;
import core.ViewHandler;
import core.ViewModelFactory;
import external.Thermometer;
import javafx.application.Application;
import javafx.stage.Stage;
import model.temperature.TemperatureModel;
import model.temperature.TemperatureModelManager;

public class ApplicationApp extends Application
{
  @Override public void start(Stage stage)
  {
    ModelFactory mf= new ModelFactory();
    ViewModelFactory viewModelFactory= new ViewModelFactory(mf);
    ViewHandler viewHandler= new ViewHandler(viewModelFactory);

    TemperatureModel model = new TemperatureModelManager();

    Thermometer thermometer= new Thermometer("t1",21,1,mf,model);
    Thermometer thermometer1= new Thermometer("t2",22,7,mf,model);
    Thread thread1= new Thread(thermometer);
    Thread thread2= new Thread(thermometer1);
    thread1.start();
    thread2.start();



    viewHandler.start();


  }
}
