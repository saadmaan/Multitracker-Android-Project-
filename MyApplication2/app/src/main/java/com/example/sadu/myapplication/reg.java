package com.example.sadu.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sadu on 11/18/2016.
 */

public class reg extends Activity implements View.OnClickListener {
    EditText etUsername, etPassword,etMobile,etCountry;
    Button btnSign1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etMobile = (EditText) findViewById(R.id.etMobile);
        etCountry = (EditText) findViewById(R.id.etCountry);
        btnSign1 = (Button) findViewById(R.id.btnSign1);
        btnSign1.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
            String name = etUsername.getText().toString();
            String pass = etPassword.getText().toString();
            String mobl = etMobile.getText().toString();
            String cont = etCountry.getText().toString();
          System.out.println(">>>>>>>>>>"+name);
        System.out.println(">>>>>>>>>>"+pass);
        System.out.println(mobl);
        System.out.println(cont);
        //System.out.println(>>>>>>>>>>name);
            String latit = "0";
            String longit = "0";
            sendRequest(name, pass,mobl,cont,latit,longit);
        }
    private void sendRequest(final String name, final String pass, final String mobl,final String cont,final String latit,final String longit) {


        StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://10.100.6.30/client/reg.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("ccx",response);
                try

                {
                    Log.i("tagconvertstr", "["+response+"]");
                    JSONObject job = new JSONObject(response);

                    String result = job.getString("get");

                    if (result.equals("success")) {
                        Intent i = new Intent(reg.this, server.class);
                        startActivity(i);
                        finish();
                    } else {
                        String errormsg = "Error";
                        Toast.makeText(reg.this, errormsg, Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    String errormsg1 = "ErrorJson";
                    Toast.makeText(reg.this, errormsg1, Toast.LENGTH_LONG).show();
                    Log.e("reg>>>>>", "exception", e);
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("ccx",error.toString());
                        Toast.makeText(reg.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("txtUsername", name);
                params.put("txtPassword", pass);
                params.put("txtMobile", mobl);
                params.put("txtCountry", cont);
                params.put("txtLatit", "0");
                params.put("txtLongit", "0");
                Log.i("ccx",name);
                Log.i("ccx",pass);
                Log.i("ccx",mobl);
                Log.i("ccx",cont);
                Log.i("ccx",latit);
                Log.i("ccx",longit);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }

}
