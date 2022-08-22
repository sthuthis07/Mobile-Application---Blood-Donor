package com.example.madlabminiproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText LoginUsn;
    EditText LoginPwd;
    Button Login;
    String user, pass;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginUsn=findViewById(R.id.username);
        LoginPwd=findViewById(R.id.password);
        user="user1";
        pass="user123";
        Login=findViewById(R.id.login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user1=LoginUsn.getText().toString();
                String pass1=LoginPwd.getText().toString();
                if(user.equals(user1)&&pass.equals(pass1)){
                    Toast.makeText(v.getContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                    Intent it = new Intent(v.getContext(),MainActivity.class);
                    startActivity(it);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }


        });
    }
}