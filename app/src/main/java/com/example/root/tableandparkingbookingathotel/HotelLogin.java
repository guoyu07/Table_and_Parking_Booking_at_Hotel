package com.example.root.tableandparkingbookingathotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * A login screen that offers login via email/password.
 */
public class HotelLogin extends AppCompatActivity  {



        String userEmail;
        EditText customer_email;
        EditText customer_password;
        String emaill;
        String password ;
       // TextView result ;

        public static final String JSON_URL = "http://172.16.40.94/hotel_signin.php";

        public static  String KEY_NUM = "email";


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_hotel_login);

            customer_email = (EditText) findViewById(R.id.customer_email);
            customer_password = (EditText) findViewById(R.id.customer_password);
            //result = (TextView)findViewById(R.id.result);

            Button signup_bottom = (Button) findViewById(R.id.signup_bottom);
            signup_bottom.setOnClickListener(
                    new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view)
                        {

                            Intent intent = new Intent(findViewById(R.id.signup_bottom).getContext(),SignUp.class);
                            startActivity(intent);
                        }
                    }
            );
            final Button SignIn = (Button) findViewById(R.id.SignIn);
            SignIn.setOnClickListener(
                    new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view)
                        {


                            Button SignIn = (Button) findViewById(R.id.SignIn);
                            SignIn.setOnClickListener(
                                    new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view)
                                        {
////
                                            emaill = customer_email.getText().toString();
                                            password = customer_password.getText().toString();
                                            sendRequest();
////                        final EditText emailpass = (EditText) findViewById(R.id.email);
////                        userEmail = emailpass.getText().toString();
//
//                                        Intent intent = new Intent(findViewById(R.id.signup_bottom).getContext(),SignUp.class);
//                                        //send the email add to nxt activity
//                                        //  intent.putExtra("emailInput",userEmail);
//
//                                        startActivity(intent);
                                        }
                                    }
                            );
                        }
                    });


        }


        private void sendRequest() {


            StringRequest stringRequest = new StringRequest(Request.Method.POST, JSON_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            showJSON(response);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(com.example.root.tableandparkingbookingathotel.HotelLogin.this, error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }) {

                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put(KEY_NUM, emaill);
                    KEY_NUM = "password";
                    params.put(KEY_NUM, password);

                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }
        //
        private void showJSON(String json)
        {
            JSON pj = new JSON(json);
            pj.JSON();

            String name1 = JSON.name;
            //result.setText(name1);
            if (name1 == "1")
            {
                final EditText email = (EditText) findViewById(R.id.customer_email);
                userEmail = email.getText().toString();

                Intent intent = new Intent(findViewById(R.id.SignIn).getContext(),HotelHome.class);
                //send the email add to nxt activity
                intent.putExtra("emailInput",userEmail);
                Toast.makeText(com.example.root.tableandparkingbookingathotel.HotelLogin.this, "Successss", Toast.LENGTH_LONG).show();

                startActivity(intent);
            }
            else
            {
                Intent intent = new Intent(findViewById(R.id.SignIn).getContext(),HotelLogin.class);
                //send the email add to nxt activity
                //intent.putExtra("emailInput",userEmail);
                startActivity(intent);
                Toast.makeText(com.example.root.tableandparkingbookingathotel.HotelLogin.this, "Invalid password or email", Toast.LENGTH_LONG).show();

            }

            // );


//

//
//        String name3 = JSON.classs;
//
//        tejas.setText(name3);
//
//
//
//
//
        }
    }
