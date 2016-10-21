package com.acadgild.anup.loginapp;

import android.graphics.Color;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginpage extends AppCompatActivity implements View.OnClickListener {


    TextView text;
    EditText emailid, password;
    Button loginbutn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        // Initialization
        text = (TextView) findViewById(R.id.warningText);
        emailid = (EditText) findViewById(R.id.etusername);
        password = (EditText) findViewById(R.id.etpassword);
        loginbutn = (Button) findViewById(R.id.butlogin);

        loginbutn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (emailid.getText().toString().length() == 0) {
            Toast.makeText(getApplicationContext(), "email id is blank", Toast.LENGTH_LONG).show();
            emailid.setError("email cannot be blank");
            text.setText(R.string.blank_email);
            text.setTextColor(Color.RED);
            text.setVisibility(View.VISIBLE);
            }
        else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailid.getText().toString()).matches()) {
                Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show();
                emailid.setError("Invalid email");
                text.setText(R.string.warn_text);
                text.setTextColor(Color.RED);
                text.setVisibility(View.VISIBLE);
            }
        else if (password.getText().toString().length() == 0) {
                Toast.makeText(getApplicationContext(), "Password cannot be blank", Toast.LENGTH_LONG).show();
                password.setError("Password cannot be blank");
                text.setText(R.string.blank_password);
                text.setTextColor(Color.RED);
                text.setVisibility(View.VISIBLE);
        }
        else {
            Toast.makeText(getApplicationContext(), "Validated Succesfully", Toast.LENGTH_LONG).show();
            text.setText(R.string.welcome);
            text.setVisibility(View.VISIBLE);
            text.setTextColor(Color.GREEN);
        }
    }
}
