package com.example.estia.medicalapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.estia.medicalapp.R;
import com.example.estia.medicalapp.model.Thermo;
import com.example.estia.medicalapp.model.ThermoDAO;

import java.util.ArrayList;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */


    // UI references. Ale ssupedo
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);


        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEmailView.getText().toString().equals("a") && mPasswordView.getText().toString().equals("a")){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        //FAKE DATA SAVED
        ThermoDAO thermoDAO = new ThermoDAO(getApplicationContext());
        ArrayList<Thermo> thermos = thermoDAO.getThermos();
        if (thermos.size() < 5 ) {
            Thermo thermo  = new Thermo(36);
            Thermo thermo1 = new Thermo(37);
            Thermo thermo2 = new Thermo(38);
            Thermo thermo3 = new Thermo(38);
            Thermo thermo4 = new Thermo(37);
            Thermo thermo5 = new Thermo(36);
            Thermo thermo6 = new Thermo(39);

            thermoDAO.save(thermo);
            thermoDAO.save(thermo1);
            thermoDAO.save(thermo2);
            thermoDAO.save(thermo3);
            thermoDAO.save(thermo4);
            thermoDAO.save(thermo5);
            thermoDAO.save(thermo6);
        }
    }

}

