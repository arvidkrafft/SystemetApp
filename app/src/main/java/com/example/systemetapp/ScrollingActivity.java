package com.example.systemetapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.systemetapp.domain.Product;

import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    Intent intent;
    List<Product> list;
    ListView listView;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        //Bundle data = getIntent().getExtras();
        //list = data.getParcelableArrayList("favorites");
        list = intent.getParcelableArrayListExtra("favorites");
        setContentView(R.layout.activity_scrolling);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //Toast toast = Toast.makeText(getApplicationContext(), list.get(0).toString(), Toast.LENGTH_LONG);
        //toast.show();
        Log.d(String.valueOf(123), String.valueOf(list.size()));
        setupListView();
    }

    private void setupListView() {
        listView = findViewById(R.id.favorite_view);
        adapter = new ArrayAdapter<Product>(this,
                android.R.layout.simple_list_item_1,
                list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        );
    }


}
