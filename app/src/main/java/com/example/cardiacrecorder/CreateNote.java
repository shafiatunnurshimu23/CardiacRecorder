package com.example.cardiacrecorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class CreateNote extends AppCompatActivity {
    EditText createTitle, createDate, createTime, heartRate, diastolic, systolic, comment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        oid onClick(View v) {
            RecordModel recordModel = new RecordModel(heartRate.getText().toString(), diastolic.getText().toString(),

                    }).addOnFailureListener(new OnFailureListener() {

        heartRate = findViewById(R.id.heartRate);
        diastolic = findViewById(R.id.diastolic);
        systolic = findViewById(R.id.systolic);
        comment = findViewById(R.id.comment);
        saveBtn = findViewById(R.id.saveNoteFabBtn);

        Toolbar toolbar = findViewById(R.id.toolbarOfCreateNote);
        toolbar.setTitle("Add Record");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        firebaseFirestore = FirebaseFirestore.getInstance();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public v
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(CreateNote.this, "Failed to Add record", Toast.LENGTH_SHORT).show();
                                }
                            });
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}