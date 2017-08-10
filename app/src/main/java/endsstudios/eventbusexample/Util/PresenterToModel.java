package endsstudios.eventbusexample.Util;

import java.util.List;

/**
 * Created by MEHMET on 9.08.2017.
 */

public class PresenterToModel {

    private List<DataModel> data;



    public void setData(List<DataModel> data){
        this.data = data;
    }

    public List<DataModel> getData() {
        return data;
    }

    public PresenterToModel(List<DataModel> data) {
        this.data = data;
    }
}