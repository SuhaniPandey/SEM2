package UpdatedNumber.model;

public interface DataModel {

    String getLastUpdateTimeStamp();
    int getNumberOfUpdates();
    void  increaseNumberOfUpdates();
}
