package com.homefuly.databaseassignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.homefuly.model.Country;

public class MainActivity extends AppCompatActivity {
    Country obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocompleteCountry);
        obj=new Country(this);
        obj.InsertData("INDIA");
        obj.InsertData("USA");
        obj.InsertData("ARGENTINA");
        obj.InsertData("PAKISTAN");
        obj.InsertData("AUSTRALIA");
        obj.InsertData("CHINA");
        obj.InsertData("JAPAN");
        obj.InsertData("JERMANY");
        obj.InsertData("RASIA");
        String[] country =obj.GetAllData();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, country);
        textView.setAdapter(adapter);
    }
}
