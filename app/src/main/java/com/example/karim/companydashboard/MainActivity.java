package com.example.karim.companydashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OpenTimer(View view){
        startActivity(new Intent(this,DurationTime.class));
    }
    public void openLocation(View view){
        startActivity(new Intent(this,GetCurrentPlace.class));
    }

    public void AddOffer(View view) {

        startActivity(new Intent(this,AddOfferAct.class));
    }
}
