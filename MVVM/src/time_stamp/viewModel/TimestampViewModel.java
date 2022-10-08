package time_stamp.viewModel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import time_stamp.model.DataModel;
import time_stamp.model.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

public class TimestampViewModel {

    private StringProperty updateTimeStamp;

    private StringProperty numberOfUpdates;

    private DataModel model;

    public TimestampViewModel(DataModel model) {
        this.model = model;
        updateTimeStamp = new SimpleStringProperty("Last update: ");
        numberOfUpdates=new SimpleStringProperty("0");
        ((PropertyChangeSubject) model).addPropertyChangeListener((PropertyChangeEvent evt) -> this.updateTimestamp());
    }

    public void updateTimestamp() {
        model.increaseNumberOfUpdates();
        Platform.runLater(() -> {
            updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
            numberOfUpdates.setValue("Number of updates:" + model.getNumberOfUpdates());
        });
    }

    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }

    public StringProperty numberOfUpdatesProperty() {
        return numberOfUpdates;
    }
}
