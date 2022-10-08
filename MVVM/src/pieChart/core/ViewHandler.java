package pieChart.core;

import javafx.fxml.FXML;
import pieChart.view.barChart.BarChartController;
import pieChart.view.pieChart.PieChartController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pieChart.view.textEditor.TextEditorController;

import java.io.IOException;

public class ViewHandler
{

  private Stage stage1;
  private Stage stage2;
  private Stage stage3;
  private ViewModelFactory viewModelFactory;
  private Scene pieChartScene;
  private Scene textEditorScene;
  private Scene barChartScene;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    stage1 = new Stage();
    stage2 = new Stage();
    stage3= new Stage();
    this.viewModelFactory = viewModelFactory;
  }

  public void start() throws Exception
  {
    openPieChartView();
    openTextEditor();
    openBarChart();
  }
/*
  public void openView(String viewToOpen) throws IOException
  {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    if ("PieChart".equals(viewToOpen))
    {
      loader.setLocation(getClass().getResource("../view/pieChart/PieChartView.fxml"));
      root = loader.load();
      PieChartController view = loader.getController();
      view.init(viewModelFactory.getPieChartViewModel());
      stage1.setTitle("Pie Chart");
      scene = new Scene(root);
      stage1.setScene(scene);
      stage1.show();
    }
    else if ("TextEditor".equals(viewToOpen))
    {
      loader.setLocation(getClass().getResource("../view/textEditor/TextEditor.fxml"));
      root = loader.load();
      TextEditorController view = loader.getController();
      view.init(viewModelFactory.getTextEditorViewModel());
      stage2.setTitle("Text Editor");
      scene = new Scene(root);
      stage2.setScene(scene);
      stage2.show();
    }

  }

 */

  public void openPieChartView()
  {
    FXMLLoader loader = new FXMLLoader();

    Parent root = loadFXMLFiles("../view/pieChart/PieChartView.fxml", loader);
    PieChartController controller = loader.getController();
    controller.init(viewModelFactory.getPieChartViewModel());

    pieChartScene = new Scene(root);
    stage1.setTitle("Pie Chart");
    stage1.setResizable(false);
    stage1.setScene(pieChartScene);
    stage1.show();

  }

  public void openTextEditor(){
    FXMLLoader loader = new FXMLLoader();

    Parent root = loadFXMLFiles("../view/textEditor/TextEditor.fxml", loader);
    TextEditorController controller= loader.getController();
    controller.init(viewModelFactory.getTextEditorViewModel());

    textEditorScene = new Scene(root);
    stage2.setTitle("Text Editor");
    stage2.setResizable(false);
    stage2.setScene(textEditorScene);
    stage2.show();
  }

  public void openBarChart(){
    FXMLLoader loader = new FXMLLoader();

    Parent root = loadFXMLFiles("../view/barChart/BarChart.fxml", loader);
    BarChartController controller= loader.getController();
    controller.init(viewModelFactory.getBarChartViewModel());

    barChartScene = new Scene(root);
    stage3.setTitle("Bar Chart");
    stage3.setResizable(false);
    stage3.setScene(barChartScene);
    stage3.show();
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
