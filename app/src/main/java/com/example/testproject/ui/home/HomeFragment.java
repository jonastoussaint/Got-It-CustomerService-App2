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

import com.example.testproject.MainActivity;
import com.example.testproject.R;
import com.example.testproject.Tickets;
import com.example.testproject.TicketsAdapter;

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
        openticketbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Fragment fragment = new Fragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainContainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);

            }
        });

        return root;
    }

}
