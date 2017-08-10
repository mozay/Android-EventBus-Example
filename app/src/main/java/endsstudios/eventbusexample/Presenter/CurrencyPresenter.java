package endsstudios.eventbusexample.Presenter;

import java.util.List;

import endsstudios.eventbusexample.Util.DataModel;

/**
 * Created by MEHMET on 9.08.2017.
 */

public interface CurrencyPresenter {
    void sendDataActivity();
    void getDataModel();
    void takeDataEvent(List<DataModel> dataModels);
}
