package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class withoutvehicle extends AppCompatActivity {
    Spinner spinnerbeg2,spinnerdest2,spinnertime2;
    Button btninwithout;
    private View mProgressView;
    private View mLoginFormView;
    private TextView tvLoad;


    String[] locbeg2 = {"Select Starting Location","Modern Edu. Soc. COEP","Koregaon Park","Shivaji Nagar","Hadapsar"};
    String[] locdest2 = {"Select Destination ","Modern Edu. Soc. COEP","Koregaon Park","Shivaji Nagar","Hadapsar"};
    String[] time2 = {"Select Time Slot","12:45 PM","1:00 PM", "1:15 PM ", "1:30 PM ","1:45 PM","2:00 PM","2:15 PM","2:30 PM",
            "2:45 PM","3:00 PM","3:15 PM","3:30 PM","3:45 PM","4:00 PM","4:15 PM","4:30 PM","4:45 PM","5:00 PM",
            "5:15 PM","5:30 PM","5:45 PM","6:00 PM","6:15 PM","6:30 PM","6:45 PM","7:00 PM","7:15 PM",
            "7:30 PM","7:45 PM","8:00 PM","8:15 PM","8:30 PM","8:45 PM","9:00 PM","9:15 PM","9:30 PM",
            "9:45 PM","10:00 PM","10:15 PM","10:30 PM","10:45 PM" ,"11:00 PM","11:15 PM","11:30 PM","11:45 PM"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withoutvehicle);

//------------------------------------------------------------------------------------------------------------------------------------

        Calendar calender2 = Calendar.getInstance();
        final String currentdate2 = DateFormat.getInstance().format(calender2.getTime());
        final String result2 = currentdate2.substring(3,5)+"/"+currentdate2.substring(0,2)+currentdate2.substring(5,8);
//------------------------------------------------------------------------------------------------------------------------------------

        spinnerbeg2 = findViewById(R.id.spinnerbeg2);
        spinnerdest2 = findViewById(R.id.spinnerdest2);
        spinnertime2 = findViewById(R.id.spinnertime2);
        btninwithout = findViewById(R.id.btninwithout);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        tvLoad = findViewById(R.id.tvLoad);
//-----------------------------------------------------------------------------------------------------------------------------------
        btninwithout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String start = spinnerbeg2.getSelectedItem().toString().trim();
                String end = spinnerdest2.getSelectedItem().toString().trim();
                String time22 = spinnertime2.getSelectedItem().toString().trim();

                String concat = start+end+time22+result2;

                Intent it =new Intent(withoutvehicle.this,com.example.afinal.list.class);

                it.putExtra("concat",concat);
                startActivity(it);
            }
        });

        ArrayAdapter bb1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, locbeg2);
        bb1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerbeg2.setAdapter(bb1);

        spinnerbeg2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 1) {
                    Toast.makeText(withoutvehicle.this, "You select Modern Edu. Soc. COE ", Toast.LENGTH_SHORT).show();
                }
                if (position == 2) {
                    Toast.makeText(withoutvehicle.this, "You select Koregaon Park", Toast.LENGTH_SHORT).show();
                }
                if (position == 3) {
                    Toast.makeText(withoutvehicle.this, "You select Shivaji Nagar", Toast.LENGTH_SHORT).show();
                }
                if (position == 4) {
                    Toast.makeText(withoutvehicle.this, "You select Hadapsar", Toast.LENGTH_SHORT).show();
                }
                if (position == 5) {
                    Toast.makeText(withoutvehicle.this, "You select Swargate", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter bb2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, locdest2);
        bb2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerdest2.setAdapter(bb2);
        spinnerdest2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    Toast.makeText(withoutvehicle.this, "You select Modern Edu. Soc. COE ", Toast.LENGTH_SHORT).show();
                }
                if (position == 2) {
                    Toast.makeText(withoutvehicle.this, "You select Koregaon Park", Toast.LENGTH_SHORT).show();
                }
                if (position == 3) {
                    Toast.makeText(withoutvehicle.this, "You select Shivaji Nagar", Toast.LENGTH_SHORT).show();
                }
                if (position == 4) {
                    Toast.makeText(withoutvehicle.this, "You select Hadapsar", Toast.LENGTH_SHORT).show();
                }
                if (position == 5) {
                    Toast.makeText(withoutvehicle.this, "You select Swargate", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter bb3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, time2);
        bb3.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnertime2.setAdapter(bb3);
        spinnertime2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
//--------------------------------------------------------------------------------------------------------------------------------
    /*
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });

            tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
            tvLoad.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
}



