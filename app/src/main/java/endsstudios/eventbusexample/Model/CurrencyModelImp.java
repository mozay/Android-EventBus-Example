package endsstudios.eventbusexample.Model;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import endsstudios.eventbusexample.Util.Const;
import endsstudios.eventbusexample.Util.DataModel;
import endsstudios.eventbusexample.Util.SingletonBus;

/**
 * Created by MEHMET on 9.08.2017.
 */

public class CurrencyModelImp implements CurrencyModel {

    List<DataModel> dataList;

    public CurrencyModelImp()
    {
        //Default Constructor
    }


    @Override
    public void getCurrencyData() {
        dataList = new ArrayList<DataModel>();
        new HttpAsyncTask().execute(Const.CurrencyURL);
    }

    @Override
    public void sendPresenter(List<DataModel> dataList) {
        SingletonBus.getBus().post(dataList);
    }

    public static String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {


            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }


    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            return GET(urls[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray=jsonObject.getJSONArray("value");
                for (int i=0;i<jsonArray.length();i++)
                {
                    DataModel dataModel = new DataModel();
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    dataModel.setBuy(jsonObject1.getString("alis"));
                    dataModel.setSale(jsonObject1.getString("satis"));
                    dataModel.setCurrency(jsonObject1.getString("adi"));
                    dataList.add(dataModel);
                }

                sendPresenter(dataList);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
