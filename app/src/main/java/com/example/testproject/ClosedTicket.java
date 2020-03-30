package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class ClosedTicket extends AppCompatActivity {

    protected RecyclerView rView;
    protected TicketsAdapter adapter;
    protected List<Tickets> taskTickets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_gallery);
        rView = findViewById(R.id.recyclerView1);
        //vertical line
        rView.addItemDecoration(new DividerItemDecoration(rView.getContext(), DividerItemDecoration.VERTICAL));
        taskTickets = new ArrayList<>();
        adapter = new TicketsAdapter(getBaseContext(), taskTickets);
        rView.setAdapter(adapter);
        rView.setLayoutManager(new LinearLayoutManager(getBaseContext()));


        ParseQuery<Tickets> query = ParseQuery.getQuery("SupportTicket");
        query.whereEqualTo("sup_status", "Closed");
        query.findInBackground(new FindCallback<Tickets>() {
            @Override
            public void done(List<Tickets> tickets, ParseException e) {
                if (e == null) {
                    adapter.clear();
                    adapter.addAll(tickets);
                } else {

                }
            }
        });
    }
}
