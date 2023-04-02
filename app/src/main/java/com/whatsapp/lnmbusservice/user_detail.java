package com.whatsapp.lnmbusservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class user_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        String[] gender = new String[]{"Male", "Female", "Prefer Not to Say"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.gender_input, gender);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteGender);
        autoCompleteTextView.setAdapter(adapter);

        String[] batch = new String[]{"Y-19", "Y-20", "Y-21", "Y-22"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.batch_input, batch);

        AutoCompleteTextView autoCompleteTextView2 = findViewById(R.id.autoCompleteBatch);
        autoCompleteTextView2.setAdapter(adapter2);

    }
}