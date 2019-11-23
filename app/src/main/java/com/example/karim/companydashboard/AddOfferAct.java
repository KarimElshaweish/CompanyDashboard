package com.example.karim.companydashboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.karim.companydashboard.Model.Offer;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;


import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;

public class AddOfferAct extends AppCompatActivity {

    EditText offerName,offerDetails;
    String offerNameText,offerDetailsText;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_offer);
        pb=findViewById(R.id.pb);
        offerName=findViewById(R.id.offerName);
        offerDetails=findViewById(R.id.offferDetails);
    }

    public void finish(View view) {
        finish();
    }
            public void AddOffer(View view) {
        offerNameText=offerName.getText().toString();
        offerDetailsText=offerDetails.getText().toString();
        if(offerNameText.equals("")){
            offerName.setError("please enter the offer name");
        }else if(offerNameText.equals("")){
            offerDetails.setError("please enter the offer details");
        }else{
            pb.setVisibility(View.VISIBLE);
            offerName.setEnabled(false);
            offerDetails.setEnabled(false);
            Offer offer=new Offer();
            offer.setDescripton(offerDetailsText);
            offer.setName(offerNameText);
            FirebaseDatabase.getInstance().getReference().child("Offer").setValue(offer).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(AddOfferAct.this, "offer Added", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }

    }

}
