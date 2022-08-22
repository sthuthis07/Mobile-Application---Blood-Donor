package com.example.madlabminiproject;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
        Button search,back;
        EditText name;
        TextView did,dtype,dname,dqty,iid,iname,itype,iqty;
        String i;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        name = findViewById(R.id.keyId);
        did = findViewById(R.id.did);
        dname = findViewById(R.id.dname);
        dqty = findViewById(R.id.uid);
        dtype = findViewById(R.id.dtype);
        search = findViewById(R.id.searchitem);
        back=findViewById(R.id.back);
        iid = findViewById(R.id.search_id);
        iname = findViewById(R.id.iname);
        iqty = findViewById(R.id.iqty);
        itype = findViewById(R.id.itype);
        back.setOnClickListener(this);
        }
@Override
public void onClick(View v)
        {
        if (v.equals(search))
        {
        iid.setText("");
        iname.setText("");
        iqty.setText("");
        itype.setText("");
        did.setText("");
        dname.setText("");
        dqty.setText("");
        dtype.setText("");
        Cursor cursor = new
        DBHelper(this).searchItem(name.getText().toString());
        if (cursor.moveToNext())
        {
        int index1= cursor.getColumnIndex("name");
        String rowId = cursor.getString(index1);
        int index2 = cursor.getColumnIndex("contact");
        String rowName = cursor.getString(index2);
        int index3 = cursor.getColumnIndex("bloodgroup");
        String rowQty = cursor.getString(index3);
        iid.setText("Donor Name:");
        iname.setText("Contact :");
        iqty.setText("Blood Group :");
        did.setText(rowId);
        dname.setText(rowName);
        dqty.setText(rowQty);
        }
        }
        if (v.equals(back))
        {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        }
        }
        }