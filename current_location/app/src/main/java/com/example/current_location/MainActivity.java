package com.example.current_location;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint; import android.content.Context;
import android.location.Address; import android.location.Geocoder; import android.location.Location;
import android.location.LocationListener; import android.location.LocationManager; import android.os.Bundle;
import android.util.Log; import android.view.View; import android.widget.Button;
import android.widget.TextView; import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}