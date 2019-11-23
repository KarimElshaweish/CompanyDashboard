package com.example.karim.companydashboard;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class DurationTime extends AppCompatActivity {

    EditText hoursText;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference mReference=database.getReference("Time");
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duration_time);
        hoursText=findViewById(R.id.hoursText);
        pb=findViewById(R.id.pb);
    }

    public void saveHours(View view){
        pb.setVisibility(View.VISIBLE);
        hoursText.setEnabled(false);
        DurationLong durationTime=new DurationLong();
        durationTime.setHours(hoursText.getText().toString());
        mReference.child("Time").setValue(durationTime).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(DurationTime.this, "Time Added", Toast.LENGTH_SHORT).show();
                finish();
                pb.setVisibility(View.GONE);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pb.setVisibility(View.GONE);
                hoursText.setEnabled(true);
                Toast.makeText(DurationTime.this, "error:"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
