package com.example.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;




public class Main1 extends AppCompatActivity {
    //First we must create a variable for the activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Button buttonA = findViewById(R.id.button);
        buttonA.setOnClickListener(v -> openActivityLogin());
        //on clicking the button
        Button buttonB = findViewById(R.id.buttonforcompany);
        buttonB.setOnClickListener(v -> openActivityEmployer());


    }
    public void openActivityLogin()
    {
        Intent intent=new Intent(Main1.this,HomeActivity.class);

        startActivity(intent);
    }
    public void openActivityEmployer()
    {
        Intent intent1=new Intent(Main1.this,EmployerActivity.class);
        startActivity(intent1);
    }

}
