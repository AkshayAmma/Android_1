package com.example.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    private Button register;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        @SuppressLint("CutPasteId") Button register = findViewById(R.id.button6);
        @SuppressLint("CutPasteId") Button login = findViewById(R.id.button5);
        register.setOnClickListener(v -> {
       startActivity(new Intent(MainActivity.this,RegActivity.class));
       finish();
        });
        login.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
            finish();
        });

    }
}
