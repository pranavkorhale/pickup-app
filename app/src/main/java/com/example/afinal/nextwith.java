package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

public class nextwith extends AppCompatActivity  {

    Spinner spinnerwith,spinnerbeg,spinnerdest,spinnertime;
    EditText phn;
    EditText nameinwith;
    Button btnwithvehicle;
    private View mProgressView;
    private View mLoginFormView;
    private TextView tvLoad;



    String[] moption = {"Select Vehicle","Prime","Mini","Micro","Auto","Two-wheeler"};
    String[] locbeg = {"Select Starting Location","Modern Edu. Soc. COEP","Koregaon Park","Shivaji Nagar","Hadapsar"};
    String[] locdest = {"Select Destination ","Modern Edu. Soc. COEP","Koregaon Park","Shivaji Nagar","Hadapsar"};
    String[] time = {"Select Time Slot","12:45 PM","1:00 PM", "1:15 PM ", "1:30 PM ","1:45 PM","2:00 PM","2:15 PM","2:30 PM",
            "2:45 PM","3:00 PM","3:15 PM","3:30 PM","3:45 PM","4:00 PM","4:15 PM","4:30 PM","4:45 PM","5:00 PM",
            "5:15 PM","5:30 PM","5:45 PM","6:00 PM","6:15 PM","6:30 PM","6:45 PM","7:00 PM","7:15 PM",
            "7:30 PM","7:45 PM","8:00 PM","8:15 PM","8:30 PM","8:45 PM","9:00 PM","9:15 PM","9:30 PM",
            "9:45 PM","10:00 PM","10:15 PM","10:30 PM","10:45 PM" ,"11:00 PM","11:15 PM","11:30 PM","11:45 PM"};
    //-------------------------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextwith);


        Calendar calender = Calendar.getInstance();
        final String currentdate = DateFormat.getInstance().format(calender.getTime());
        final String result = currentdate.substring(3,5)+"/"+currentdate.substring(0,2)+currentdate.substring(5,8);


        spinnerwith=findViewById(R.id.spinnerwith);
        spinnerbeg=findViewById(R.id.spinnerbeg);
        spinnerdest=findViewById(R.id.spinnerdest);
        spinnertime=findViewById(R.id.spinnertime);
        btnwithvehicle=findViewById(R.id.btnwithvehicle);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        tvLoad = findViewById(R.id.tvLoad);

        phn=findViewById(R.id.phn);
        nameinwith = findViewById(R.id.nameinwith);
        //--------------------------------------------------------------------------------------------------------------
        //to generate the choice
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,moption);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerwith.setAdapter(aa);


        //spin click handler
        spinnerwith.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //spinnerwith.getBackground().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_ATOP);
                //((TextView) spinnerwith.getSelectedView()).setTextColor(Color.BLUE);
              //  ((TextView) spinnerwith.getSelectedView()).setTextSize(Size.20);

                if(position==1)
                {
                    Toast.makeText(nextwith.this, "You select Prime ", Toast.LENGTH_SHORT).show();
                }
                if(position==2)
                {
                    Toast.makeText(nextwith.this, "You select Mini", Toast.LENGTH_SHORT).show();
                }
                if(position==3)
                {
                    Toast.makeText(nextwith.this, "You select Micro", Toast.LENGTH_SHORT).show();
                }
                if(position==4)
                {
                    Toast.makeText(nextwith.this, "You select Auto", Toast.LENGTH_SHORT).show();
                }
                if(position==5)
                {
                    Toast.makeText(nextwith.this, "You select Two-wheeler", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
      //----------------------------------------------------------------------------------------------------------------------

       ArrayAdapter aa1=new ArrayAdapter(this,android.R.layout.simple_spinner_item,locbeg);
                aa1.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinnerbeg.setAdapter(aa1);
                spinnerbeg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        //Modern Edu. Soc. COE","Koregaon Park","Shivaji Nagar","Hadapsar",Swargate

                        if(position==1)
                        {
                            Toast.makeText(nextwith.this, "You select Modern Edu. Soc. COEP ", Toast.LENGTH_SHORT).show();
                        }
                        if(position==2)
                        {
                            Toast.makeText(nextwith.this, "You select Koregaon Park", Toast.LENGTH_SHORT).show();
                        }
                        if(position==3)
                        {
                            Toast.makeText(nextwith.this, "You select Shivaji Nagar", Toast.LENGTH_SHORT).show();
                        }
                        if(position==4)
                        {
                            Toast.makeText(nextwith.this, "You select Hadapsar", Toast.LENGTH_SHORT).show();
                        }
                        if(position==5)
                        {
                            Toast.makeText(nextwith.this, "You select Swargate", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
        //------------------------------------------------------------------------------------------------------------------------

        ArrayAdapter aa2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,locdest);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerdest.setAdapter(aa2);
        spinnerdest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==1)
                {
                    Toast.makeText(nextwith.this, "You select Modern Edu. Soc. COE ", Toast.LENGTH_SHORT).show();
                }
                if(position==2)
                {
                    Toast.makeText(nextwith.this, "You select Koregaon Park", Toast.LENGTH_SHORT).show();
                }
                if(position==3)
                {
                    Toast.makeText(nextwith.this, "You select Shivaji Nagar", Toast.LENGTH_SHORT).show();
                }
                if(position==4)
                {
                    Toast.makeText(nextwith.this, "You select Hadapsar", Toast.LENGTH_SHORT).show();
                }
                if(position==5)
                {
                    Toast.makeText(nextwith.this, "You select Swargate", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //------------------------------------------------------------------------------------------------------------

        ArrayAdapter aa3 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,time);
                aa3.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnertime.setAdapter(aa3);
        spinnertime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)

            {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        //-------------------------------------------------------------------------------------------------------------

        btnwithvehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String vehicle_name = spinnerwith.getSelectedItem().toString().trim();
                String location = spinnerbeg.getSelectedItem().toString().trim();
                String destination = spinnerdest.getSelectedItem().toString().trim();
                String phone_no=phn.getText().toString().trim();
                String name=nameinwith.getText().toString().trim();
                String time = spinnertime.getSelectedItem().toString().trim();
                String mix33 =location+destination+time+result;
             //   Toast.makeText(nextwith.this, "see "+mix33, Toast.LENGTH_SHORT).show();

                Travel travel = new Travel();
                travel.setName(name);
                travel.setLocation(location);
                travel.setDestination(destination);
                travel.setVehicle_name(vehicle_name);
                travel.setTime(time);
                travel.setPhone_no(phone_no);
                travel.setCurrentdate(result);
                //-------------------------------------------
              travel.setMix(mix33);
               //-----------------------------------------------





                if(location.equals("Select Starting Location") || destination.equals("Select Destination") || nameinwith.getText().toString().isEmpty() || phn.getText().toString().isEmpty() || spinnerwith.getSelectedItem().toString().isEmpty() || spinnertime.getSelectedItem().toString().isEmpty() ||
                        spinnerdest.getSelectedItem().toString().isEmpty() || spinnerbeg.getSelectedItem().toString().isEmpty())
                {

                    Toast.makeText(nextwith.this, "please fill the all fields...", Toast.LENGTH_SHORT).show();
                }
                else
                {
            //Here we store all data at backendless database

                    showProgress(true);
                    tvLoad.setText("Uploading the data...");
                    Backendless.Persistence.save(travel, new AsyncCallback<Travel>() {
                        @Override
                        public void handleResponse(Travel response) {
                            Toast.makeText(nextwith.this, "New date save sucessfully", Toast.LENGTH_SHORT).show();
                            showProgress(false);
                            nameinwith.setText("");
                            phn.setText("");



                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {
                            Toast.makeText(nextwith.this, "Error..."+fault.getMessage(), Toast.LENGTH_SHORT).show();
                            showProgress(false);
                        }
                    });

                }
            }
        });


    }


    //----------------------------------------------------------------------------------------------------------------------
    /**
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
