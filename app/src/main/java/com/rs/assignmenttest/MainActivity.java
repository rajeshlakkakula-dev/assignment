package com.rs.assignmenttest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.rs.assignmenttest.models.EmployeesModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;
    Button btn_sign_in;
    String jsonobjData = "";


    private final String URL = "http://www.checkgaadi.com/reporting/vrm/api/test_new/int/gettabledata.php";
    HashMap<String, String> params = new HashMap<String, String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Initializing the variables
         */
        et_username = findViewById(R.id.et_user_name);
        et_password = findViewById(R.id.et_password);
        btn_sign_in = findViewById(R.id.btn_sign_in);


    }


    public void signInButton(View view) {

        String userName = et_username.getText().toString();
        String password = et_password.getText().toString();

        if (userName.matches("") && password.matches("")) {
            Toast.makeText(this, "Enter Username & password", Toast.LENGTH_LONG).show();


        } else {

            params.put("username", userName);
            params.put("password", password);

            final JsonObjectRequest request_json = new JsonObjectRequest(URL, new JSONObject(params),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {


                            try {
                                jsonobjData = response.getString("TABLE_DATA");
                                Log.i("JSONDATA",jsonobjData);
                                Intent intent = new Intent(MainActivity.this, ListDetails.class);
                                intent.putExtra("jsonData", jsonobjData);
                                startActivity(intent);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                            Log.d("Response:", response.toString());


                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {

                    VolleyLog.e("Error:", error.getMessage());


                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(request_json);



        }


    }
}
