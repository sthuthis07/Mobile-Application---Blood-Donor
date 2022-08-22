package com.example.madlabminiproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button insert,update,delete,view,search;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert=findViewById(R.id.insertBtn);
        update=findViewById(R.id.updateBtn);
        delete=findViewById(R.id.deleteBtn);
        search=findViewById(R.id.searchBtn);
        view=findViewById(R.id.viewBtn);
        DB=new DBHelper(this);
        insert.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
        search.setOnClickListener(this);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(view))
        {
            Intent it = new Intent(this, ViewActivity.class);
            startActivity(it);
        }
        else if(v.equals(search))
        {
            Intent it = new Intent(this, SearchActivity.class);
            startActivity(it);
        }
        if(v.equals(delete))
        {
            Intent it = new Intent(this, DeleteActivity.class);
            startActivity(it);
        }
        if(v.equals(update))
        {
            Intent it = new Intent(this, UpdateActivity.class);
            startActivity(it);
        }
        if(v.equals(insert))
        {
            Intent it = new Intent(this, InsertActivity.class);
            startActivity(it);
        }

    }
}