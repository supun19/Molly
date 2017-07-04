package com.example.supun.molly.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.supun.molly.Model.Item;
import com.example.supun.molly.R;

import java.util.ArrayList;

/**
 * Created by supun on 27/06/17.
 */

public class CartAdapter extends ArrayAdapter<Item> {

    public CartAdapter(Context context, ArrayList<Item> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Item item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_cart, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.type);
        TextView tvHome = (TextView) convertView.findViewById(R.id.specification);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.boxCh);
        // Populate the data into the template view using the data object
        tvName.setText("Black and White Long Top");
        tvHome.setText("UK 10/Black");

        if(item.isSelected()){
            checkBox.setChecked(true);
            checkBox.setVisibility(View.GONE);
        }

        // Return the completed view to render on screen
        return convertView;
    }
}
