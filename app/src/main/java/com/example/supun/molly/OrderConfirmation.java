package com.example.supun.molly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.supun.molly.Adapter.CartAdapter;
import com.example.supun.molly.Model.Item;
import com.example.supun.molly.Model.PaymentModel;
import com.example.supun.molly.Model.QrModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class OrderConfirmation extends AppCompatActivity {

    private Button payNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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

        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.buddhikajay.mobilepay");
        if (launchIntent != null) {
            //null pointer check in case package name was not found
            QrModel model = new QrModel();
            model.setAmount("LKR2090.00");
            model.setId("1549f642-3a50-49a0-8f57-31b2ab94841e");
            model.setTag("main");
            model.setHaveCustomTypes(false);
            PaymentModel paymentModel = new PaymentModel();
            paymentModel.setTip(false);
            paymentModel.setDynamic(false);
            paymentModel.addQrModel(model);
            paymentModel.setInnerApp(true);


           // bundle.putSerializable("Paymodel",paymentModel);
            //launchIntent.("Paymodel",paymentModel);
            launchIntent.putExtra("Paymodel",paymentModel.toString());
           /* JSONObject paymodel = new JSONObject();
            try {
                paymodel.put("tip",false);
                paymodel.put("dynamic",false);
                paymodel.put("innerApp",true);
                JSONObject model = new JSONObject();
                model.put("amount","LKR 2090.00");
                model.put("merchantId","1549f642-3a50-49a0-8f57-31b2ab94841e");
                model.put("tag","main");
                JSONArray models = new JSONArray();
                models.put(model);
                paymodel.put("qrModels",models);

            } catch (JSONException e) {
                e.printStackTrace();
            }*/

            //launchIntent.putExtra("paymodel",paymentModel.toString());
            startActivity(launchIntent);

        }
        //Intent intent = new Intent(this,QrActivity.class);
        //startActivity(intent);

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.order_confirmation_bar, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // User chose the "Settings" item, show the app settings UI...
                Intent intent = new Intent(this,cartActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_bin:
                return true;
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
