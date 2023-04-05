package com.whatsapp.lnmbusservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Bus> list;

    public MyAdapter(Context context, ArrayList<Bus> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.busentry, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {

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

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView arrival, departure, time, seat;

        public MyViewHolder(View itemView) {
            super(itemView);

            arrival = itemView.findViewById(R.id.busArrival);
            departure = itemView.findViewById(R.id.busDeparture);
            time = itemView.findViewById(R.id.busTime);
            seat = itemView.findViewById(R.id.busSeats);
        }
    }
}
