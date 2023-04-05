package com.whatsapp.lnmbusservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.whatsapp.lnmbusservice.AdminLogin.ShowError;

public class AdminOperations extends AppCompatActivity {

    MaterialButton button, all_btn;
    TextInputLayout id,arrival,destination,time,seats;

    int bus_id;
    int bus_seat;

    String busId,busArrival,busDesti,busTime,busSeats;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_operations);

        button = findViewById(R.id.Busadd);
        all_btn = findViewById(R.id.Busshow);

        id = findViewById(R.id.busID);
        arrival = findViewById(R.id.from);
        destination = findViewById(R.id.desti);
        time = findViewById(R.id.Bustime);
        seats = findViewById(R.id.Busseats);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertData();
            }
        });

        all_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminOperations.this, BusBook.class));
                finish();
            }
        });

    }

    private void InsertData(){



        if(id.getEditText()!=null && arrival.getEditText()!=null && destination.getEditText()!=null && time.getEditText()!=null && seats.getEditText()!=null){
            busId = (id.getEditText().getText().toString());
            busArrival = arrival.getEditText().getText().toString();
            busDesti = destination.getEditText().getText().toString();
            busTime = time.getEditText().getText().toString();
            busSeats = (seats.getEditText().getText().toString());
        }

        if (busId.isEmpty()) {
            ShowError(id, "Please Fill this field");
            return;
        }
        if (busArrival.isEmpty()) {
            ShowError(arrival, "Please Fill this field");
            return;
        }
        if (busDesti.isEmpty()) {
            ShowError(destination, "Please Fill this field");
            return;
        }
        if (busTime.isEmpty()) {
            ShowError(time, "Please Fill this field");
            return;
        }
        if (busSeats.isEmpty()) {
            ShowError(seats, "Please Fill this field");
            return;
        }

        //String Id = databaseReference.push().getKey();

        Bus bus = new Bus(busId,busArrival,busDesti,busTime,busSeats);
        String Id = "Bus " + busId;
        databaseReference.child("Bus_Details").child(Id).setValue(bus)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(AdminOperations.this, "Bus Details Inserted Sucessfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                });



    }
}