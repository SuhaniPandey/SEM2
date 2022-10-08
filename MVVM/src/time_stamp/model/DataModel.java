package time_stamp.model;

public interface DataModel {

    String getLastUpdateTimeStamp();
    void increaseNumberOfUpdates();
    int getNumberOfUpdates();
    int getNUmberOfUpdatesEveryTenSec();
}
