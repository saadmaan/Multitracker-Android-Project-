package com.example.sadu.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
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
import com.google.android.gms.gcm.Task;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import org.json.JSONObject;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

//import static com.example.sadu.myapplication.R.id.etCountry;
//import static com.example.sadu.myapplication.R.id.etMobile_no;

/**
 * Created by sadu on 11/3/2016.
 */

public class server extends Activity implements View.OnClickListener {
    EditText etUsername, etPassword;   //etMobile_no,etCountry;
    Button btnLogin,btnSign;
    public static String  user,name;
    final String LOG = "MainActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        etUsername = (EditText) findViewById(R.id.etUsername);
        user = etUsername.getText().toString();
        etPassword = (EditText) findViewById(R.id.etPassword);
        //etMobile_no = (int) findViewById(etMobile_no);
        //etCountry = (EditText) findViewById(etCountry);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSign = (Button) findViewById(R.id.btnSign);
        btnSign.setOnClickListener(this);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btnLogin) {
             name = etUsername.getText().toString();
            String pass = etPassword.getText().toString();
            sendRequest(name, pass);


        }
        else if(v.getId()== R.id.btnSign){
            Intent j=new Intent(this,reg.class);
            startActivity(j);
        }
    }

    private void sendRequest(final String email, final String password) {


        StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://10.100.6.30/client/login.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("ccx",response);
                try

                {
                    JSONObject job = new JSONObject(response);

                    String result = job.getString("get");

                    if (result.equals("success")) {
                        Intent i = new Intent(server.this, button.class);
                        startActivity(i);
                        finish();
                    } else {
                        String errormsg = "Error";
                        Toast.makeText(server.this, errormsg, Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    String errormsg1 = "ErrorJson";
                    Log.e("server", "exception", e);
                    Toast.makeText(server.this, errormsg1, Toast.LENGTH_LONG).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("ccx",error.toString());
                        Toast.makeText(server.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("txtUsername", email);
                params.put("txtPassword", password);
                Log.i("ccx",email);
                Log.i("ccx",password);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(40000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(stringRequest);

    }




}




