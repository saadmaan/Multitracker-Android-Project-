package com.example.sadu.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.id.button2;

/**
 * Created by sadu on 2/11/2017.
 */

public class button extends Activity implements View.OnClickListener{
    Button button2,button5,button4;
  EditText et1;
    String usera;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.but);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        et1 = (EditText) findViewById(R.id.et1);
        usera = et1.getText().toString();
}
    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.button2) {
             newmap.a= "oza";
            Intent i = new Intent(button.this, userlist.class);
            startActivity(i);
            finish();
        }
        if(v.getId()== R.id.button5) {
           // newmap.a= "sadu";
            Intent i = new Intent(button.this, MapsActivity.class);
            startActivity(i);
            finish();
        }
        if(v.getId()== R.id.button4) {
             newmap.a= usera;
            Intent i = new Intent(button.this, newmap.class);
            startActivity(i);
            finish();
        }
    }
}
