package com.example.sadu.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sadu on 2/11/2017.
 */

public class userlist extends Activity {
    String user1, user2, user3, user4, user5, user6, user7, user8;
    TextView us1, us2, us3, us4, us5, us6, us7, us8;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
        us1 = (TextView) findViewById(R.id.t1);
        user1 = us1.getText().toString();
        us2 = (TextView) findViewById(R.id.t2);
        user2 = us1.getText().toString();
        us3 = (TextView) findViewById(R.id.t3);
        user3 = us1.getText().toString();
        us4 = (TextView) findViewById(R.id.t4);
        user4 = us1.getText().toString();
        us5 = (TextView) findViewById(R.id.t5);
        user5 = us1.getText().toString();
        us6 = (TextView) findViewById(R.id.t6);
        user6 = us1.getText().toString();
        us7 = (TextView) findViewById(R.id.t7);
        user7 = us1.getText().toString();
        us8 = (TextView) findViewById(R.id.t8);
        user8 = us1.getText().toString();
       // final String[] arr = new String[20];
        //request();
//        StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://10.100.6.30/client/json.php", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                Log.i("ccx",response);
//                try
//
//                {
//                    JSONObject job = new JSONObject(response);
//                    JSONArray jsonArray = job.getJSONArray("result");
//                    //Loop through array
//                    for (int i = 0; i<jsonArray.length(); i++)
//                    {
//                        arr[i] = jsonArray.getString(i);
//                    }
//                } catch (Exception e) {
//                    Log.e("USERLIST", "exception", e);
//                   // Toast.makeText(userlist.this, errormsg1, Toast.LENGTH_LONG).show();
//                }
//            }
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.i("ccx",error.toString());
//                        Toast.makeText(userlist.this, error.getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                });
//
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        stringRequest.setRetryPolicy(new DefaultRetryPolicy(40000,
//                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//        requestQueue.add(stringRequest);


    }

    public void back(View view) {
        Intent intent = new Intent(userlist.this,button.class);
        startActivity(intent);
    }
}