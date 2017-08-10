package endsstudios.eventbusexample.Model;

import java.util.List;

import endsstudios.eventbusexample.Util.DataModel;

/**
 * Created by MEHMET on 9.08.2017.
 */

public interface CurrencyModel {
    void getCurrencyData();
    void sendPresenter(List<DataModel> dataList);
}
