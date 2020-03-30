package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button signin;
    private EditText etxtUsername, etxtPassword;
    private String id = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signin = findViewById(R.id.button);

      /*  //using just for testing purposes | delete when done :)
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeNav.class);
                startActivity(intent);
            }
        });
        //using just for testing purposes | deleting stops here :) */

        etxtUsername = findViewById(R.id.username);
        etxtPassword = findViewById(R.id.password);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etxtUsername.getText().toString();
                String password = etxtPassword.getText().toString();
                validateUser(username, password);


            }
        });
    }

    private void validateUser(String username, String password) {


        //Query to check user input against object (username)
        ParseQuery<ParseObject> userQuery = ParseQuery.getQuery("InternalUser");
        userQuery.whereEqualTo("inu_username", username);
        userQuery.whereEqualTo("inu_password", password);
        userQuery.whereEqualTo("inu_type", "CustomerService");

        //Query to check user input against object (password)
        //ParseQuery<ParseObject> pwordQuery = ParseQuery.getQuery("InternalUser");
        //pwordQuery.whereEqualTo("inu_password", password);

        //Do compound query to validate both username AND password for a specific object
        //List<ParseQuery<ParseObject>> queries = new ArrayList<>();
        //queries.add(userQuery);
        //queries.add(pwordQuery);
        //ParseQuery<ParseObject> mainQuery = ParseQuery.or(queries);
        userQuery.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> results, ParseException e) {
                if (e == null) {
                    Log.d("users", "Retrieved " + results.size() + " users");

                    if(results.size() == 0)
                    {
                        Toast.makeText(MainActivity.this, "Invalid user credentials", Toast.LENGTH_SHORT).show();
                        //return;
                    }
                   else {
                        id = results.get(0).getObjectId();
                        HomeNav();
                    }


                } else {
                    Log.d("users", "Error: " + e.getMessage());
                    Toast.makeText(MainActivity.this, "Invalid user credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void HomeNav() {
        Log.d("id", id);
        Intent intent = new Intent(MainActivity.this, HomeNav.class);
        intent.putExtra("username", id);
        startActivity(intent);

        //finish();
    }
}
