package com.maarten.amplitudesampleapp;

/* This is a simple app to take a location and submit it to Angel List for a simple list of Start ups */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.amplitude.api.Amplitude;
import java.util.ArrayList;




public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Amplitude.initialize(this, "46f921e8322f091559869d65c0c01784");
        setContentView(R.layout.activity_main);

        Amplitude.startSession();
        ListView myListView = (ListView)findViewById(R.id.listView);
        final EditText myEditText = (EditText)findViewById(R.id.myEditText);

        //create an array of list items
        final ArrayList<String> resultsList = new ArrayList<String>();
        //Create the array adapter
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultsList);
        //Bind the adapter
        myListView.setAdapter(aa);

        myEditText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Amplitude.logEvent("Added an element");
                resultsList.add(0, myEditText.getText().toString());
                aa.notifyDataSetChanged();
                myEditText.setText("");
            }
        });
        Amplitude.endSession();
    }



/*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.amplitude, menu);
        return true;
    }*/
    
}
