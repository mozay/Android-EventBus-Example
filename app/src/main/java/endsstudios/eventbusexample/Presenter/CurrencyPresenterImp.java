package endsstudios.eventbusexample.Presenter;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import endsstudios.eventbusexample.Model.CurrencyModel;
import endsstudios.eventbusexample.Util.DataModel;
import endsstudios.eventbusexample.Util.PresenterToModel;
import endsstudios.eventbusexample.Util.SingletonBus;
import endsstudios.eventbusexample.View.MainActivity;

import static android.R.id.message;

/**
 * Created by MEHMET on 9.08.2017.
 */

public class CurrencyPresenterImp implements CurrencyPresenter {


    private final MainActivity view;
    private final CurrencyModel model;
    List<DataModel> dataModels;
    PresenterToModel presenterToModel;

    public CurrencyPresenterImp(MainActivity view, CurrencyModel model)
    {
        this.view = view;
        this.model = model;
        SingletonBus.getBus().register(this);
    }


    @Override
    public void sendDataActivity() {
        presenterToModel = new PresenterToModel(dataModels);
        SingletonBus.getBus().post(presenterToModel);
        SingletonBus.getBus().unregister(this);
    }

    @Override
    public void getDataModel() {
        model.getCurrencyData();
    }

    @Subscribe
    @Override
    public void takeDataEvent(List<DataModel> dataModels) {
        this.dataModels = dataModels;
        sendDataActivity();
    }
}
