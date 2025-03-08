package com.example.firebaseauth;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;



public class display extends AppCompatActivity {
    private TextView textview;
    public FirebaseFirestore db=FirebaseFirestore.getInstance();
    private final CollectionReference ref = db.collection("employers");


protected void onCreate(Bundle SavedInstanceState) {
    super.onCreate(SavedInstanceState);
    setContentView(R.layout.activity_display);
    textview=findViewById(R.id.textView5);
    String position = getIntent().getStringExtra("pos");
    Query q=ref.whereEqualTo("vacancy",position);
    q.get().addOnSuccessListener(queryDocumentSnapshots -> {
        Toast.makeText(display.this, "The search is successful", Toast.LENGTH_SHORT).show();
        StringBuilder data = new StringBuilder();
        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
            employer e;
            e = new employer();
            e.setEditdocumentid(documentSnapshot.getId());
            String documentid = e.getEditdocumentid();
            String name = documentSnapshot.getString("name");
            String cname = documentSnapshot.getString("company name");
            String phone = documentSnapshot.getString("phone");
            String city = documentSnapshot.getString("city");
            String country = documentSnapshot.getString("country");
            String vac = documentSnapshot.getString("vacancy");
            //             data = String.format("%sDocument ID: %s\nEmployer name: %s\n Company name: %s\n Phone: %s\n City: %s\n Country: %s\n Vacancy: %s\n\n", data, documentid, name, cname, phone, city, country, vac);
            data.append(data).append("Document ID: ").append(documentid).append("\n Employer name: ").append(name).append("\n Company name: ").append(cname).append("\n Phone: ").append(phone).append("\n City: ").append(city).append("\n Country :").append(country).append("\n Vacancy: ").append(vac).append("\n");
        }
        textview.setText(data.toString());

    }).addOnFailureListener(e -> Toast.makeText(display.this, "Search failed "+e, Toast.LENGTH_SHORT).show());
}
}