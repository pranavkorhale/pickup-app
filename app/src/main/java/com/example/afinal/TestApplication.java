package com.example.afinal;

import android.app.Application;
import com.backendless.Backendless;
import com.backendless.BackendlessUser;

import java.util.List;
import java.util.ListIterator;

//Here we connect the our project to backendless database

public class TestApplication extends Application {
    public static final String APPLICATION_ID = "87AF8613-449A-7ED1-FFD8-F664F7420800";
    public static final String API_KEY = "42EB9A18-7904-40D4-9C99-7D318DB1E90F";
    public static final String SERVER_URL = "https://api.backendless.com";


    public static BackendlessUser user;
    public static List<Travel>vehicles;
    @Override
    public void onCreate() {
        super.onCreate();


        Backendless.setUrl( SERVER_URL );
        Backendless.initApp(getApplicationContext(),APPLICATION_ID,API_KEY);
    }
}
