package com.example.transportbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.transportbooking.remote.Api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class UserForm extends AppCompatActivity implements View.OnClickListener {

    Button submitBooking;
    EditText fullname;
    EditText address;
    EditText email;
    EditText phoneNo;
    EditText seats;

    //Api
    public static final String ROOT_URL = "http://192.168.43.214/TransportApi/";


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);

        //operationFunctions
        getSupportActionBar().hide();


        //viewInitialization
        submitBooking = (Button) findViewById(R.id.submit);
        fullname = (EditText) findViewById(R.id.fullname);
        fullname = (EditText) findViewById(R.id.address);
        email = (EditText) findViewById(R.id.email);
        phoneNo = (EditText) findViewById(R.id.phoneNo);
        seats = (EditText) findViewById(R.id.seats);

        submitBooking.setOnClickListener(this);

    }

    private void insertUser() {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(ROOT_URL).build();
        Api api = adapter.create(Api.class);
        api.insertUser(fullname.getText().toString(), address.getText().toString(), email.getText().toString(), phoneNo.getText().toString(), seats.getText().toString(),
                new Callback<Response>() {
                    public void success(Response result, Response response) {
                        BufferedReader reader = null;
                        String output = "";

                        try {
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(UserForm.this, output, Toast.LENGTH_LONG).show();
                        boatCompanies();
                    }

                    public void failure(RetrofitError error) {
                        Toast.makeText(UserForm.this, error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void boatCompanies() {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        insertUser();
    }
}