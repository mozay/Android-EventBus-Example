package endsstudios.eventbusexample.Util;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by MEHMET on 9.08.2017.
 */

public class LoadingDialog extends ProgressDialog {


    public ProgressDialog progressDialog;
    Context context;
    String message;

    public LoadingDialog(Context context,String message) {
        super(context);
        this.context=context;
        this.message = message;
        this.progressDialog = new ProgressDialog(this.context);
        this.progressDialog.setCancelable(false);
        this.progressDialog.setMessage(this.message);
    }

    public void showDialog(){
        this.progressDialog.show();
    }

    public void closeDialog(){
        this.progressDialog.dismiss();
    }





}
