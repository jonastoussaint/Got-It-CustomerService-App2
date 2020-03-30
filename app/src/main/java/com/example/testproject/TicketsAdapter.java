package com.example.testproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.example.testproject.ui.gallery.GalleryFragment;

import java.util.ArrayList;
import java.util.List;

public class TicketsAdapter extends RecyclerView.Adapter<TicketsAdapter.ViewHolder> implements Filterable {
    private Context context;
    private List<Tickets> tickets;
    private List<Tickets> ticketsFull;

    public TicketsAdapter(Context context, List<Tickets> tickets){

        this.context = context;
        this.tickets = tickets;
        //make copy of list
        ticketsFull = new ArrayList<>(tickets);
    }

    @NonNull
    @Override
    public TicketsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mytask, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketsAdapter.ViewHolder holder, int position) {
        Tickets ticket = tickets.get(position);
        holder.bind(ticket);

    }

    public void clear(){
        tickets.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Tickets> ticket){
        tickets.addAll(ticket);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }

    @Override
    public Filter getFilter(){
        return exampleFilter;
    }

//Filter
    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Tickets> filteredList = new ArrayList<>();

            if(charSequence == null  || charSequence.length() == 0){
                filteredList.addAll(ticketsFull);
            }else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for(Tickets item : ticketsFull){
                    //filter for status
                    if(item.getType().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values =filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            //clear the list and add searched contents only
            tickets.clear();
            tickets.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView ticketNum;
        private TextView ticketDate;
        private TextView ticketType;
        private TextView ticketStatus;
        private ConstraintLayout container;
        public ViewHolder(@NonNull View itemView){
            super(itemView);

            ticketNum = itemView.findViewById(R.id.ticketNum_lbl);
            ticketDate = itemView.findViewById(R.id.ticketDate_lbl);
            ticketType = itemView.findViewById(R.id.ticketType);
            ticketStatus = itemView.findViewById(R.id.ticketStatus_lbl);
            container = itemView.findViewById(R.id.container);

           container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Tickets ticket = new Tickets();
                    Intent intent = new Intent(context , ResolveTicket.class);
                    String tick = ticketNum.getText().toString().replace("Ticket Number: ", "");
                    intent.putExtra("ticket", tick);
                    context.startActivity(intent);
                }
            });
        }

        public void bind(Tickets ticket){
            ticketNum.setText("Ticket Number: " + ticket.getObjectId());
            ticketDate.setText("Date: " + ticket.getDate());
            ticketType.setText("Type: " + ticket.getType());
            ticketStatus.setText("Status: " + ticket.getStatus());
        }

    }
}
