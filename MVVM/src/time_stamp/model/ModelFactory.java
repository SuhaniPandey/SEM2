package time_stamp.model;

import time_stamp.model.DataModel;
import time_stamp.model.DataModelManager;

public class ModelFactory {

    private DataModel dataModel;

    public DataModel getDataModel() {
        if(dataModel == null) {
            dataModel = new DataModelManager();
        }
        return dataModel;
    }


}
