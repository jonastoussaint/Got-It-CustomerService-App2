package com.example.testproject.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.ApprovedTickets;
import com.example.testproject.ClosedTicket;
import com.example.testproject.OpenTickets;
import com.example.testproject.PendingTickets;
import com.example.testproject.R;
import com.example.testproject.Tickets;
import com.example.testproject.TicketsAdapter;
import com.example.testproject.DriverTickets;
import com.example.testproject.VendorTickets;

import java.util.List;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    protected RecyclerView rView;
    protected TicketsAdapter adapter;
    protected List<Tickets> taskTickets;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        // example for button onclick
        final Button openticketbtn = root.findViewById(R.id.openticket_btn);
        final Button closedticketbtn = root.findViewById(R.id.closedticket_btn);
        final Button pendingticketbtn = root.findViewById(R.id.pendingticket_btn);
        final Button aprrovedticketbtn = root.findViewById(R.id.approvedtickets_btn);
        final Button driverTicket= root.findViewById(R.id.deliveryticket_btn);
        final Button customerTicket = root.findViewById(R.id.vendorticket_btn);

        //button for open tickets
        openticketbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Fragment fragment = new Fragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainContainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/

                Intent intent = new Intent(getContext(), OpenTickets.class);
                startActivity(intent);

            }
        });

        //button for closed tickets
        closedticketbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), ClosedTicket.class);
                startActivity(intent);

            }
        });

        //button for pending tickets
        pendingticketbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), PendingTickets.class);
                startActivity(intent);

            }
        });

        //button for approved tickets
        aprrovedticketbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), ApprovedTickets.class);
                startActivity(intent);

            }
        });

        //button for Delivery tickets
        driverTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), DriverTickets.class);
                startActivity(intent);

            }
        });

        //button for Delivery tickets
        customerTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), VendorTickets.class);
                startActivity(intent);

            }
        });

        return root;
    }

}
