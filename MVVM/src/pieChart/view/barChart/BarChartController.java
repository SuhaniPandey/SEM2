package pieChart.view.barChart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.awt.*;

public class BarChartController
{
  @FXML BarChart barChart;
  @FXML Label update;


  private BarChartViewModel barChartViewModel;
  private XYChart.Data<String, Integer> x= new XYChart.Data<String,Integer>("X",0);
  private XYChart.Data<String, Integer> y= new XYChart.Data<String,Integer>("Y",0);
  private XYChart.Data<String, Integer> z= new XYChart.Data<String,Integer>("Z",0);


  public void init(BarChartViewModel barChartViewModel){

    this.barChartViewModel=barChartViewModel;
    x.YValueProperty().bind(barChartViewModel.xProperty());
    y.YValueProperty().bind(barChartViewModel.yProperty());
    z.YValueProperty().bind(barChartViewModel.zProperty());

    XYChart.Series yellowSeries=new XYChart.Series();
    yellowSeries.setName("X");
    yellowSeries.getData().add(x);
    barChart.getData().add(yellowSeries);

    XYChart.Series greenSeries=new XYChart.Series();
    greenSeries.setName("Y");
    greenSeries.getData().add(y);
    barChart.getData().add(greenSeries);

    XYChart.Series redSeries=new XYChart.Series();
    redSeries.setName("Z");
    redSeries.getData().add(z);
    barChart.getData().add(redSeries);

  }
  public void onUpdateButton()
  {
    System.out.println("Hello");
    System.out.println(barChart.getData());
    barChartViewModel.updateBarChart();
  }
}
