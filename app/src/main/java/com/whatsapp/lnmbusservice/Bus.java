package com.whatsapp.lnmbusservice;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Bus {

    private String Id;
    private String Arrival;
    private String Destination;
    private String Time;
    private String Seats;

    public Bus() {
    }

    public String getId() {
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

    public String getSeats() {
        return Seats;
    }

    public Bus(String Id, String arrival, String destination, String time, String seats) {
        this.Id = Id;
        Arrival = arrival;
        Destination = destination;
        Time = time;
        Seats = seats;
    }
}
