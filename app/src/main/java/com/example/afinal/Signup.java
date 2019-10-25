package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class Signup extends AppCompatActivity {

    private View mProgressView;
    private View mLoginFormView;
    private TextView tvLoad;

    EditText etname,etlastname,etemail,etpassword,etconfirm;
    Button btnsignup2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etname=findViewById(R.id.etname);
        etlastname=findViewById(R.id.etlastname);
        etemail=findViewById(R.id.etemail);
        etpassword=findViewById(R.id.etpassword);
        etconfirm=findViewById(R.id.etconfirm);
        btnsignup2=findViewById(R.id.btnsignup2);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        tvLoad = findViewById(R.id.tvLoad);


        btnsignup2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(etemail.getText().toString().isEmpty()||etpassword.getText().toString().isEmpty()||etconfirm.getText().toString().isEmpty())
                {

                            Toast.makeText(Signup.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(etpassword.getText().toString().trim().equals(etconfirm.getText().toString().trim()))
                    {
                   /* Intent intent1=new Intent(Signup.this,com.example.afinal.MainActivity.class);
                    startActivity(intent1);*/
                   String name=etname.getText().toString().trim();
                   String email=etemail.getText().toString().trim();
                   String password=etpassword.getText().toString().trim();

                        final BackendlessUser user=new BackendlessUser();
                        user.setEmail(email);
                        user.setPassword(password);
                        user.setProperty("name",name); //here first argument is name of column
                        showProgress(true);
                        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
                            @Override
                            public void handleResponse(BackendlessUser response) {
                                Toast.makeText(Signup.this, "User sucessfully register", Toast.LENGTH_SHORT).show();
                                Signup.this.finish();
                            }

                            @Override
                            //it show fault if the user already exist
                            public void handleFault(BackendlessFault fault) {
                                Toast.makeText(Signup.this, "Error "+fault.getMessage(), Toast.LENGTH_SHORT).show();
                                showProgress(false);

                            }
                        });

                }
                else
                    {
                        Toast.makeText(Signup.this, "Make sure that your password and re-type password is the same", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }


    //--------------------------------------------------------------------------------






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
