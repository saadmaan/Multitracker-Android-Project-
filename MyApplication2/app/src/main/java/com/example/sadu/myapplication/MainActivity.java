package com.example.sadu.myapplication;

/**
 * Created by sadu on 11/4/2016.
 */
        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;

        import com.google.android.gms.location.LocationRequest;
        import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i=new Intent(this,server.class);
        startActivity(i);
       // setContentView(R.layout.abc);
    }

}