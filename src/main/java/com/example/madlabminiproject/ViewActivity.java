package com.example.madlabminiproject;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DBHelper db;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Items> itemsList = new ArrayList<>();
    ItemsAdapter itemsAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_view);
        recyclerView=findViewById(R.id.items);
        recyclerView.setHasFixedSize(true);
        db = new DBHelper(this);
        itemsList = db.selectItems();
        layoutManager = new LinearLayoutManager(ViewActivity.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        itemsAdapter = new ItemsAdapter(this,itemsList,recyclerView);
        recyclerView.setAdapter(itemsAdapter);
    }

}