package pieChart.view.textEditor;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pieChart.model.DataModel;

public class TextEditorViewModel
{

  private StringProperty x;
  private StringProperty y;
  private StringProperty z;
  private StringProperty updateTimeStamp;
  private DataModel model;

  public TextEditorViewModel(DataModel model)
  {
    x= new SimpleStringProperty();
    y= new SimpleStringProperty();
    z= new SimpleStringProperty();
    updateTimeStamp= new SimpleStringProperty();
    this.model = model;
  }

  public void updateTextField(){
    double[] dataValues = model.getDataValues();
    x.setValue(String.valueOf(dataValues[0]));
    y.setValue(String.valueOf(dataValues[1]));
    z.setValue(String.valueOf(dataValues[2]));
    updateTimeStamp.setValue(model.getLastUpdateTimeStamp());
  }

  public void saveChanges(){
    Double[] doubles= new Double[3];
    doubles[0] = Double.parseDouble(x.getValue());
    doubles[1] = Double.parseDouble(y.getValue());
    doubles[2] = Double.parseDouble(z.getValue());
    model.saveData(doubles);

  }

  public StringProperty xProperty()
  {
    return x;
  }


  public StringProperty yProperty()
  {
    return y;
  }

  public StringProperty zProperty()
  {
    return z;
  }
}
