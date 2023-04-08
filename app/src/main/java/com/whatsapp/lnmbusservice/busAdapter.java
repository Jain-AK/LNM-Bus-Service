package com.whatsapp.lnmbusservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class busAdapter extends RecyclerView.Adapter<busAdapter.Holder> {

    Context context;
    ArrayList<Bus> list;

    public busAdapter(Context context, ArrayList<Bus> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.showbus, parent, false);
        return new busAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Bus bus = list.get(position);

        holder.arrival.setText(bus.getArrival());
        holder.departure.setText(bus.getDestination());
        holder.time.setText(bus.getTime());
        holder.seat.setText(bus.getSeats());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        TextView arrival, departure, time, seat;

        Button button;

        public Holder(View itemView) {
            super(itemView);

            arrival = itemView.findViewById(R.id.Arrival_bus);
            departure = itemView.findViewById(R.id.Depart_bus);
            time = itemView.findViewById(R.id.Time_bus);
            seat = itemView.findViewById(R.id.Seats_bus);

            button =itemView.findViewById(R.id.book_seat);
        }
    }
}
