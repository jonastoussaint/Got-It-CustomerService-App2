package com.example.testproject.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.testproject.InternalUser;
import com.example.testproject.R;
import com.example.testproject.Tickets;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        return root;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        final TextView iufName = view.findViewById(R.id.txtIUFName);
        final TextView iulName = view.findViewById(R.id.txtIULName);
        final TextView iuuName = view.findViewById(R.id.txtIUsername);
        final Button button = view.findViewById(R.id.btnChanges);

        //set the current username when user logged in
        Bundle extra = getActivity().getIntent().getExtras();
        final String user = extra.getString("internalUserName");
        iuuName.setText(user);

        //query to get the user first and last name
        final ParseQuery<ParseObject> query = ParseQuery.getQuery("InternalUser");
        query.whereEqualTo("inu_username", user);
        query.findInBackground(new FindCallback<ParseObject>() {
            // @Override
            public void done(final List<ParseObject> object, ParseException e) {
                final ParseObject testObject = new ParseObject("InternalUser");
                if (e == null) {
                    //set first and last name found in database
                    iufName.setText(object.get(0).getString("inu_first_name"));
                    iulName.setText(object.get(0).getString("inu_last_name"));
                    //update the database
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //puts data back into the database but not updating the existing row!!
                            object.get(0).put("inu_first_name",iufName.getText().toString());
                            object.get(0).put("inu_last_name",iulName.getText().toString());
                            /*query.put("inu_first_name", iufName.getText().toString());
                            query.put("inu_last_name", iulName.getText().toString());*/



                        }
                    });

            } else{

                }

            }
        });

    }

    //Ignore this
       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // query.
                //query.put("inu_first_name", iufName.toString());
            }
        });
    }*/
}
