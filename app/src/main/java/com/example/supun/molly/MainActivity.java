package com.example.supun.molly;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // get Spinner reference
        Spinner spinner_type = (Spinner) findViewById(R.id.spinner_type);

        // Spinner click listener
        spinner_type.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List types = new ArrayList();
        types.add("UK Size 6(xs)/Black");
        types.add("UK Size 6(xs)/Blue");
        types.add("UK Size 6(xs)/Red");
        types.add("UK Size 6(xs)/White");

        // Creating array adapter for spinner
        ArrayAdapter dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, types);

        // Drop down style will be listview with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_type.setAdapter(dataAdapter);


        // get Spinner reference
        Spinner spinner_quentity = (Spinner) findViewById(R.id.spinner_quentity);

        // Spinner click listener
        spinner_quentity.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List quentity = new ArrayList();
        quentity.add("1");
        quentity.add("2");
        quentity.add("3");
        quentity.add("4");

        // Creating array adapter for spinner
        ArrayAdapter dataAdapterQuentity = new ArrayAdapter(this, android.R.layout.simple_spinner_item, quentity);

        // Drop down style will be listview with radio button
        dataAdapterQuentity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_quentity.setAdapter(dataAdapterQuentity);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // getting selected item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item in toast
        //Toast.makeText(parent.getContext(), "Selected Country: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_bar, menu);
        return true;
    }
}
