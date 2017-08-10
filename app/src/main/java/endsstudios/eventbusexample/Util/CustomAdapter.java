package endsstudios.eventbusexample.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import endsstudios.eventbusexample.R;

/**
 * Created by MEHMET on 9.08.2017.
 */

public class CustomAdapter extends BaseAdapter {

    List<DataModel> mListItems;
    private LayoutInflater mLayoutInflater;
    PresenterToModel presenterToModel;

    public CustomAdapter(Context context, PresenterToModel model){

        mListItems = model.getData();

        //get the layout inflater
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        //getCount() represents how many items are in the list
        return mListItems.size();
    }

    @Override
    //get the data of an item from a specific position
    //i represents the position of the item in the list
    public Object getItem(int i) {
        return null;
    }

    @Override
    //get the position id of the item from the list
    public long getItemId(int i) {
        return 0;
    }

    @Override

    public View getView(int position, View view, ViewGroup viewGroup) {

        //check to see if the reused view is null or not, if is not null then reuse it
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.list_item, null);
        }

        //get the string item from the position "position" from array list to put it on the TextView

            TextView moneyName = (TextView) view.findViewById(R.id.moneyType);
            moneyName.setText(mListItems.get(position).getCurrency());


            TextView buying = (TextView) view.findViewById(R.id.buying);
            buying.setText(mListItems.get(position).getBuy());

            TextView sales = (TextView) view.findViewById(R.id.sales);
            sales.setText(mListItems.get(position).getSale());


        //this method must return the view corresponding to the data at the specified position.
        return view;

    }
}
