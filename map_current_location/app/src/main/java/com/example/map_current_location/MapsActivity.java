package com.example.map_current_location;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint; import android.content.Context;
import android.location.Address; import android.location.Geocoder; import android.location.Location;
import android.location.LocationListener; import android.location.LocationManager; import android.os.Bundle;
import android.util.Log; import android.view.View; import android.widget.Button;
import android.widget.TextView; import java.util.List;
import java.util.Locale;

public class MapsActivity extends AppCompatActivity implements LocationListener { TextView locationinfotv;
    protected LocationManager locationManager; Button locationbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); getSupportActionBar().hide(); setContentView(R.layout.activity_maps);

        locationinfotv = findViewById(R.id.locationinfotv); locationbtn = findViewById(R.id.locationbtn);

        locationbtn.setOnClickListener(new View.OnClickListener() { @Override

        public void onClick(View v) { getLocation();
        }
        });

    }

    void getLocation() { try {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
                this);
    }
    catch(SecurityException e) { e.printStackTrace();
    }
    }





    /**
     *	Manipulates the map once available.
     *	This callback is triggered when the map is ready to be used.
     *	This is where we can add markers or lines, add listeners or move the camera. In this case,
     *	we just add a marker near Sydney, Australia.
     *	If Google Play services is not installed on the device, the user will be prompted to install
     *	it inside the SupportMapFragment. This method will only be triggered once the user has
     *	installed Google Play services and returned to the app.
     */


    @SuppressLint("SetTextI18n") @Override
    public void onLocationChanged( Location location) { locationinfotv.setText("Latitude:" + location.getLatitude() + ", Longitude:" +
            location.getLongitude()); try {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault()); List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),
                location.getLongitude(), 4); locationinfotv.setText(locationinfotv.getText() +
                "\n"+addresses.get(0).getAddressLine(0)+", "+
                addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2));

    }catch(Exception e)
    {	}

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) { Log.d("Latitude","enable");
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) { Log.d("Latitude","disable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) { Log.d("Latitude","status");
    }
}
