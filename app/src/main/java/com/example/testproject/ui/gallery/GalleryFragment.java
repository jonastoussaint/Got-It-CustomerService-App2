package com.example.testproject.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.R;
import com.example.testproject.Tickets;
import com.example.testproject.TicketsAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    protected RecyclerView rView;
    protected TicketsAdapter adapter;
    protected List<Tickets> taskTickets;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        return root;
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        rView = view.findViewById(R.id.recyclerView1);
        //vertical line
        rView.addItemDecoration(new DividerItemDecoration(rView.getContext(), DividerItemDecoration.VERTICAL));
        taskTickets = new ArrayList<>();
        adapter = new TicketsAdapter(getContext(), taskTickets);
        rView.setAdapter(adapter);
        rView.setLayoutManager(new LinearLayoutManager(getContext()));


        ParseQuery<Tickets> query = ParseQuery.getQuery("SupportTicket");
        query.findInBackground(new FindCallback<Tickets>() {
            @Override
            public void done(List<Tickets> tickets, ParseException e) {
                if(e == null){
                    adapter.clear();
                    adapter.addAll(tickets);
                }else {

                }
            }
        });
    }

}
