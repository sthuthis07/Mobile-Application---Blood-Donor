package com.example.madlabminiproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity implements View.OnClickListener{

    Button insert;
    EditText name,bloodgroup,contact;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        name=findViewById(R.id.iName);
        contact=findViewById(R.id.icontact);
        bloodgroup=findViewById(R.id.ibloodgroup);
        insert=findViewById(R.id.insert);
        insert.setOnClickListener(this);
    }
    public void onClick(View v)
    {


        if(v.equals(insert))
        {
            String res;
            long r = new DBHelper(this).addItem(name.getText().toString(),contact.getText().toString(),bloodgroup.getText().toString());
            if(r==-1)
            {
                res= "Insertion of item "+name.getText().toString()+" failed !!";
            }
            else
            {
                res= "Item "+name.getText().toString()+" successfully inserted !!";
            }
            Toast to = Toast.makeText(this,res, Toast.LENGTH_LONG);
            to.show();
            Intent it = new Intent(this,MainActivity.class);
            startActivity(it);
        }
    }
}
