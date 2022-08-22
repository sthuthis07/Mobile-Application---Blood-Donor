package com.example.madlabminiproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    

    EditText id,name,contact,bloodgroup;
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        name=findViewById(R.id.uname);
        contact=findViewById(R.id.ucontact);
        bloodgroup=findViewById(R.id.ubloodgroup);
        update=findViewById(R.id.updateitem);
    }
    @Override
    public void onClick(View v)
    {
        if(v.equals(update))
        {
            String res;
            long r = new
                    DBHelper(this).updateItem(name.getText().toString(),contact.getText().toString(),bloodgroup.getText().toString());
            if(r==-1)
                res = "Updating "+name.getText().toString()+" Failed !!";
            else
                res = name.getText().toString()+" successfully updated !!";
            Toast t = Toast.makeText(this, res, Toast.LENGTH_LONG);
            t.show();
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }
    }
}