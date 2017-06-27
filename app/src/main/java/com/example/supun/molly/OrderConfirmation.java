package com.example.supun.molly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.supun.molly.Adapter.CartAdapter;
import com.example.supun.molly.Model.Item;

import java.util.ArrayList;

public class OrderConfirmation extends AppCompatActivity {

    private Button payNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

        // Construct the data source
        ArrayList<Item> items = new ArrayList<Item>();
// Create the adapter to convert the array to views
        CartAdapter adapter = new CartAdapter(this, items);
// Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.order_cart_items);
        listView.setAdapter(adapter);
        Item item = new Item(12.33, "Black & White Long Tops");
        adapter.add(item);

        payNow = (Button) findViewById(R.id.button_pay_now);

        payNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payNow();
            }
        });
    }
    private void payNow(){
        Intent intent = new Intent(this,QrActivity.class);
        startActivity(intent);

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_directpayApp:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_visa_master:
                if (checked)
                    // Ninjas rule
                    break;

            case R.id.radio_bank_transfer:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
