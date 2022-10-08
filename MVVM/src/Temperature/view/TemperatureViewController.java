package Temperature.view;

import Temperature.core.ViewHandler;
import Temperature.mediator.TemperatureModel;
import Temperature.model.Temperature;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureViewController
{
   @FXML private Label outputLabel;
   @FXML private TextField filterField;
   @FXML private Label filterLabel;

   private ViewHandler viewHandler;
   private TemperatureViewModel model;
   private Region root;
   private String thermometerId;

   public TemperatureViewController()
   {
   }

   public void init(ViewHandler viewHandler, TemperatureViewModel model)
   {
      this.viewHandler = viewHandler;
      this.model = model;
      thermometerId = null;
     // model.addListener("TemperatureAdded",this::propertyChange);

   }

   public void reset()
   {
      // empty
   }


   @FXML private void updateButtonPressed()
   {
      model.getValue();
   }

   @FXML private void onFilter()
   {
      model.updateThermometerID();
//
   }


}
