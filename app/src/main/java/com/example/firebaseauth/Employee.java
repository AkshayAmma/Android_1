package com.example.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Employee extends AppCompatActivity {

    private EditText editename, editposition, editpcity, editecountry;
    private TextView edob;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        // Initialize views
        edob = findViewById(R.id.textView2);
        editename = findViewById(R.id.editText2);
        editposition = findViewById(R.id.editText4);
        editpcity = findViewById(R.id.editText8);
        editecountry = findViewById(R.id.editText9);
        Button search = findViewById(R.id.button9);
        Button enter = findViewById(R.id.button4);

        // Set onClickListener for 'enter' button to add data to Firebase
        enter.setOnClickListener(v -> {
            String ename = editename.getText().toString();
            String position = editposition.getText().toString();
            String dob = edob.getText().toString();
            String pcity = editpcity.getText().toString();
            String ecountry = editecountry.getText().toString();

            // Create a map of the data to be added to Firestore
            Map<String, Object> map = new HashMap<>();
            map.put("employee name", ename);
            map.put("position", position);
            map.put("preferred city", pcity);
            map.put("country", ecountry);
            map.put("DOB", dob);

            // Add the data to Firestore
            db.collection("Employees").add(map)
                    .addOnSuccessListener(documentReference ->
                            Toast.makeText(Employee.this, "Data has been stored successfully", Toast.LENGTH_SHORT).show())
                    .addOnFailureListener(e ->
                            Toast.makeText(Employee.this, "Error! " + e, Toast.LENGTH_SHORT).show());
        });

        // Set onClickListener for 'edob' TextView to show DatePickerDialog
        edob.setOnClickListener(v -> {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            // Use Material Components theme for the DatePickerDialog
            DatePickerDialog dialog = new DatePickerDialog(
                    Employee.this,
                    R.style.CustomDialogTheme,  // Use your custom dialog theme or one of the Material themes
                    mDateSetListener,
                    year, month, day
            );

            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });

        // DatePickerDialog listener for setting selected date
        mDateSetListener = (view, year, month, dayOfMonth) -> {
            month++; // Adjust for zero-based month index
            Log.d("Employee.this", "onDateset:mm/dd/yyyy" + month + "/" + dayOfMonth + "/" + year);
            String date = month + "/" + dayOfMonth + "/" + year;
            edob.setText(date);  // Set the selected date to TextView
        };

        // Set onClickListener for 'search' button to search for employees based on position
        search.setOnClickListener(v -> {
            String position = editposition.getText().toString();
            Toast.makeText(Employee.this, "Display the details", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getBaseContext(), display.class);
            i.putExtra("pos", position);
            startActivity(i);  // Start the display activity to show employees with matching position
        });
    }

    // Deprecated methods have been removed
    // You can remove the following two methods as they aren't used anymore:
    // public void search(View view) {}
    // public void enter(View view) {}
}
