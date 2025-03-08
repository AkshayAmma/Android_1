package com.example.firebaseauth;  // This should match the namespace in build.gradle

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class Choose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Button employee = findViewById(R.id.button8);
        Button employer = findViewById(R.id.button7);

        employee.setOnClickListener(v -> {
            startActivity(new Intent(Choose.this, Employee.class));
            finish();
            Toast.makeText(Choose.this, "Successful!!", Toast.LENGTH_SHORT).show();
        });

        employer.setOnClickListener(v -> {
            startActivity(new Intent(Choose.this, EmployerActivity.class));
            finish();
            Toast.makeText(Choose.this, "Successful!!", Toast.LENGTH_SHORT).show();
        });
    }
}
