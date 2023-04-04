package com.whatsapp.lnmbusservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;

public class AdminOperations extends AppCompatActivity {

    MaterialButton button;
    TextInputLayout id,arrival,destination,time,seats;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_operations);



    }
}