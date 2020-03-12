package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testproject.ui.gallery.GalleryFragment;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

public class ResolveTicket extends AppCompatActivity {
    private String ticketNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resolve_ticket);

        final TextView tickDate = findViewById(R.id.ticketDate);
        final TextView tickStatus = findViewById(R.id.txtStatus);
        final TextView tickType = findViewById(R.id.ticketType);
        final TextView tickDecription = findViewById(R.id.ticketDesc);
        final TextView tickComplaint = findViewById(R.id.ticketComplaint);
        final TextView ticketSolution = findViewById(R.id.ticketSolution);
        final Button btnResolve = findViewById(R.id.btnResolve);

        Bundle extra = getIntent().getExtras();
        ticketNumber = extra.getString("ticket");

        final TextView tickNum = findViewById(R.id.tickNum);
        tickNum.setText(ticketNumber);

        final ParseQuery<Tickets> query = ParseQuery.getQuery("SupportTicket");
        query.whereEqualTo("objectId", ticketNumber);
        query.findInBackground(new FindCallback<Tickets>() {
            @Override
            public void done(List<Tickets> tickets, ParseException e) {
                if(e == null){
                    tickDate.setText(tickets.get(0).getDate().toString());
                    tickStatus.setText(tickets.get(0).getStatus());
                    tickType.setText(tickets.get(0).getType());
                    tickDecription.setText(tickets.get(0).getDescription());
                    tickComplaint.setText(tickets.get(0).getComplaint());
                    ticketSolution.setText(tickets.get(0).getResolution());

                }else {

                }
                //once button is pressed

            }
        });

        btnResolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseQuery<Tickets> query = ParseQuery.getQuery("SupportTicket");

                query.getInBackground(tickNum.getText().toString(), new GetCallback<Tickets>() {
                    @Override
                    public void done(Tickets ticket, ParseException e) {
                        if (e == null) {
                            //display the textView with input
                            ticket.setStatus(tickStatus.getText().toString());
                            ticket.setResolution(ticketSolution.getText().toString());
                            //save info back to the database
                            ticket.saveInBackground();

                            Toast toast = Toast.makeText(getApplicationContext(),"Ticket Successfully Resolved", Toast. LENGTH_LONG);
                            toast.show();

                            Intent intent = new Intent(getApplicationContext(), GalleryFragment.class);
                            startActivity(intent);
                        }
                        else{
                            Toast toast = Toast.makeText(getApplicationContext(),"Unable to resolve ticket", Toast. LENGTH_LONG);
                            toast.show();
                        }
                    }
                });
            }
        });



    }
}
