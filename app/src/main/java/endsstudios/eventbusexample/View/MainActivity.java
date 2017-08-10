package endsstudios.eventbusexample.View;

import android.content.Context;
import android.icu.util.Currency;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;

import endsstudios.eventbusexample.Model.CurrencyModelImp;
import endsstudios.eventbusexample.Presenter.CurrencyPresenter;
import endsstudios.eventbusexample.Presenter.CurrencyPresenterImp;
import endsstudios.eventbusexample.R;
import endsstudios.eventbusexample.Util.CustomAdapter;
import endsstudios.eventbusexample.Util.LoadingDialog;
import endsstudios.eventbusexample.Util.PresenterToModel;
import endsstudios.eventbusexample.Util.SingletonBus;

public class MainActivity extends AppCompatActivity implements MainView {

    Context context;
    LoadingDialog loadingDialog;

    private CurrencyPresenter presenter;
    ListView dataListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        initializer();
    }

    private void initializer() {
        dataListView = (ListView)findViewById(R.id.currencyList);
        loadingDialog = new LoadingDialog(context,getResources().getString(R.string.loading));
        if(CheckInternet())
        {
            showDialog();
            presenter = new CurrencyPresenterImp(MainActivity.this,new CurrencyModelImp());
            presenter.getDataModel();
        }
        else
        {
            closeDialog();
            errorMessage(getResources().getString(R.string.networkError));
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        SingletonBus.getBus().register(context);
    }

    @Override
    public void onStop() {
        super.onStop();
        SingletonBus.getBus().unregister(context);
    }

    @Override
    public void showDialog() {
        loadingDialog.showDialog();
    }

    @Override
    public void closeDialog() {
        loadingDialog.closeDialog();
    }

    @Override
    public boolean CheckInternet() {
        ConnectivityManager conMgr = (ConnectivityManager) getSystemService (Context.CONNECTIVITY_SERVICE);

        if (conMgr.getActiveNetworkInfo() != null

                && conMgr.getActiveNetworkInfo().isAvailable()

                && conMgr.getActiveNetworkInfo().isConnected()) {

            return true;

        } else {

            return false;

        }
    }

    @Override
    public void errorMessage(String message) {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

    @Subscribe
    @Override
    public void getData(PresenterToModel model) {
        CustomAdapter adapter = new CustomAdapter(context,model);
        dataListView.setAdapter(adapter);
        closeDialog();
    }
}
