package endsstudios.eventbusexample.View;

import endsstudios.eventbusexample.Util.PresenterToModel;

/**
 * Created by MEHMET on 9.08.2017.
 */

public interface MainView {

    void showDialog();
    void closeDialog();
    boolean CheckInternet();
    void errorMessage(String message);
    void getData(PresenterToModel model);
}
