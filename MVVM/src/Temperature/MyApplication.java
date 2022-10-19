package Temperature;

import Temperature.external.Thermometer;
import Temperature.mediator.TemperatureModel;
import Temperature.mediator.TemperatureModelManager;
import Temperature.core.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    // Model
    TemperatureModel model = new TemperatureModelManager();
    Thermometer thermometer= new Thermometer("t1",21,2,model);
    Thermometer thermometer1= new Thermometer("t2",22,3,model);
    Thread thread1= new Thread(thermometer);
    Thread thread2= new Thread(thermometer1);
    thread1.start();
    thread2.start();

    // View
    //ViewHandler view = new ViewHandler(model);
    //view.start(primaryStage);
  }
}
