package UpdatedNumber.viewModel;

import UpdatedNumber.model.DataModel;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TimestampViewModel {

    private StringProperty updateTimeStamp;

    private DataModel model;
    private StringProperty numberOfUpdates;

    public TimestampViewModel(DataModel model) {
        this.model = model;
        updateTimeStamp = new SimpleStringProperty("Last update: ");
        numberOfUpdates= new SimpleStringProperty("Number of Updates: ");
    }

    public void updateTimestamp() {
        updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
        model.increaseNumberOfUpdates();
        numberOfUpdates.setValue("Number of Updated: "+model.getNumberOfUpdates());
    }


    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }
    public StringProperty updateNumber(){
        return numberOfUpdates;
    }
}
