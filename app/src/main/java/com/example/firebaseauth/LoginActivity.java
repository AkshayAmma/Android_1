package com.example.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;



public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.editText);
        password=findViewById(R.id.editText3);
        Button login = findViewById(R.id.button);
        mAuth=FirebaseAuth.getInstance();
        login.setOnClickListener(v -> {
            String txt_email=email.getText().toString();
            String txt_password=password.getText().toString();
            loginUser(txt_email,txt_password);
            startActivity(new Intent(LoginActivity.this,Choose.class));
            finish();
        });
    }
    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(authResult -> Toast.makeText(LoginActivity.this, "Logged in Successfully!", Toast.LENGTH_SHORT).show());
    }
}
