package com.example.tracknba;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class Login extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("NBA") && password.getText().toString().equals("NBA")) {
                    Toast.makeText(Login.this, "LOGIN SUCCESFULL", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login.this, "LOGIN FAILED!", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }
}