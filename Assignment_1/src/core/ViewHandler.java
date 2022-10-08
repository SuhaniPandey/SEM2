package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.radiator.RadiatorController;
import view.temperature.TemperatureController;
import view.temperature.TemperatureViewModel;

import java.io.IOException;

public class ViewHandler
{

  private Scene radiatorScene;
  private Scene temperatureScene;
  private ViewModelFactory viewModelFactory;
  private Stage stage1;
  private Stage stage2;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    stage1= new Stage();
    stage2= new Stage();
    this.viewModelFactory= viewModelFactory;
  }

  public void start() {
    openRadiatorView();
    openTemperatureView();

  }

  public void openRadiatorView(){
    FXMLLoader loader= new FXMLLoader();

    Parent root= loadFXMLFiles("../view/radiator/Radiator.fxml",loader);
    RadiatorController controller= loader.getController();
    controller.init(viewModelFactory.getRadiatorViewModel(),this);

    radiatorScene= new Scene(root);
    stage1.setTitle("Radiator View");
    stage1.setResizable(false);
    stage1.setScene(radiatorScene);
    stage1.show();
  }

  public void openTemperatureView(){
    FXMLLoader loader= new FXMLLoader();

    Parent root= loadFXMLFiles("../view/temperature/Temperature.fxml",loader);
    TemperatureController temperatureController= loader.getController();
    temperatureController.init(viewModelFactory.temperatureViewModel(),this);

    temperatureScene= new Scene(root);
    stage2.setTitle("Temperature view");
    stage2.setResizable(false);
    stage2.setScene(temperatureScene);
    stage2.show();
  }

  private Parent loadFXMLFiles(String path, FXMLLoader loader)
  {
    loader.setLocation(getClass().getResource(path));
    Parent root = null;
    try
    {
      // loading fxml files in parent instance, containing all GUI elements
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }
}
