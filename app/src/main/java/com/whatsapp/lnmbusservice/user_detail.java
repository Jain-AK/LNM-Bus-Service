package com.whatsapp.lnmbusservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import static com.whatsapp.lnmbusservice.AdminLogin.ShowError;

public class user_detail extends AppCompatActivity {

    TextInputLayout inputFirstName, inputLastName, inputBatch, inputGender;

    MaterialButton button;

    String userFirstName, userLastName, userBatch, userGender;


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

        inputFirstName = findViewById(R.id.input_first_name_details);
        inputLastName = findViewById(R.id.input_last_name_details);
        inputGender = findViewById(R.id.input_gender_details);
        inputBatch = findViewById(R.id.input_batch_details);

        button = findViewById(R.id.btn_continue_details);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (inputFirstName.getEditText() != null && inputLastName.getEditText() != null && inputGender.getEditText() != null) {
                    userFirstName = inputFirstName.getEditText().getText().toString().toLowerCase();
                    userLastName = inputLastName.getEditText().getText().toString().toLowerCase();
                    userBatch = inputBatch.getEditText().getText().toString();
                    userGender = inputGender.getEditText().getText().toString();
                }

                if (userFirstName.isEmpty()) {
                    ShowError(inputFirstName, "Please Fill this field");
                    return;
                }
                if (userLastName.isEmpty()) {
                    ShowError(inputLastName, "Please Fill this field");
                    return;
                }
                if (userGender.isEmpty()) {
                    ShowError(inputGender, "Please Fill this field");
                    return;
                }
                if (userBatch.isEmpty()) {
                    ShowError(inputGender, "Please Fill this field");
                    return;
                }

                startActivity(new Intent(user_detail.this, bookBus.class));
                finish();

            }
        });

    }
}