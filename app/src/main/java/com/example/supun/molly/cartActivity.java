package com.example.supun.molly;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.supun.molly.Adapter.CartAdapter;
import com.example.supun.molly.Model.Item;

import java.util.ArrayList;

public class cartActivity extends AppCompatActivity {

    private Button buy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_closs);

        // Construct the data source
        ArrayList<Item> items = new ArrayList<Item>();
// Create the adapter to convert the array to views
        CartAdapter adapter = new CartAdapter(this, items);
// Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.cart_items);
        listView.setAdapter(adapter);
        Item item = new Item(12.33, "Black & White Long Tops");
        adapter.add(item);


        buy = (Button) findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    buyItems();
            }
        });


    }
    private void buyItems(){
        Intent intent = new Intent(this,OrderConfirmation.class);
        startActivity(intent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // User chose the "Settings" item, show the app settings UI...
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                return true;


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}
