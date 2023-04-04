package com.whatsapp.lnmbusservice;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Bus {

    private int Id;
    private String Arrival;
    private String Destination;
    private String Time;
    private int Seats;

    public Bus() {
    }

    public int getId() {
        return Id;
    }

    public String getArrival() {
        return Arrival;
    }

    public String getDestination() {
        return Destination;
    }

    public String getTime() {
        return Time;
    }

    public int getSeats() {
        return Seats;
    }

    public Bus(int Id, String arrival, String destination, String time, int seats) {
        this.Id = Id;
        Arrival = arrival;
        Destination = destination;
        Time = time;
        Seats = seats;
    }
}
