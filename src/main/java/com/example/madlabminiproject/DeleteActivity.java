package com.example.madlabminiproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener
{
    Button delete;
    EditText id;
    String i;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        id=findViewById(R.id.uid);
        delete=findViewById(R.id.deleteitem);
    }
    @Override
    public void onClick(View v)
    {
        if(v.equals(delete))
        {
            String res;
            i=id.getText().toString();
            long r = new DBHelper(this).deleteItem(i);
            if(r==-1)
            {
                res="Deletion of "+i+" failed, maybe because item "+id+" doesnt exist";
            }
            else
            {
                res = i+" successfuly deleted";
            }
            Toast t = Toast.makeText(this, res, Toast.LENGTH_LONG);
            t.show();
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }
    }
}