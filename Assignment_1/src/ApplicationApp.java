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
    ModelFactory mf = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(mf);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);

    TemperatureModel model = new TemperatureModelManager();

    Thermometer thermometerOutdoor = new Thermometer("t0", mf,
        viewModelFactory);
    Thermometer thermometer = new Thermometer("t1", 21, 1, mf,
        viewModelFactory);
    Thermometer thermometer1 = new Thermometer("t2", 22, 7, mf,
        viewModelFactory);

    new Thread(thermometer).start();
    new Thread(thermometer1).start();
    new Thread(thermometerOutdoor).start();

    viewHandler.start();

  }
}
