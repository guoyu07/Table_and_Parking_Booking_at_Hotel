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

public class SignUp extends AppCompatActivity {

    public static final String JSON_URL = "http://172.16.40.94/cust_signup.php";
    public static  String KEY_NUM = "name";
    EditText customer_name ;
    EditText customer_contact;
    EditText customer_email;
    EditText customer_password;
    EditText customer_confirm_password;
    Button SignIn;
    String name;
    String contact;
    String email;
    String password;
    String confirm_password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_sign_up);

        customer_name = (EditText) findViewById(R.id.customer_name);
        customer_contact = (EditText) findViewById(R.id.customer_contact);
        customer_email = (EditText) findViewById(R.id.customer_email);
        customer_password = (EditText) findViewById(R.id.customer_password);
        customer_confirm_password = (EditText) findViewById(R.id.customer_confirm_password);

        SignIn = (Button) findViewById(R.id.SignIn);
        SignIn.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        SignIn.setOnClickListener(
                                new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View view)
                                    {
////
                                        name = customer_name.getText().toString();
                                        contact = customer_contact.getText().toString();
                                        email = customer_email.getText().toString();
                                        password = customer_password.getText().toString();
                                        confirm_password = customer_confirm_password.getText().toString();
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
                        Toast.makeText(com.example.root.tableandparkingbookingathotel.SignUp.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_NUM, name);
                KEY_NUM = "phno";
                params.put(KEY_NUM, contact);
                KEY_NUM = "email";
                params.put(KEY_NUM, email);
                KEY_NUM = "password";
                params.put(KEY_NUM, password);
                KEY_NUM = "cpassword";
                params.put(KEY_NUM, confirm_password);
                KEY_NUM = "password";
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
        if (name1 == "1")
        {
//            final EditText email = (EditText) findViewById(R.id.customer_email);
//            userEmail = email.getText().toString();

            Intent intent = new Intent(findViewById(R.id.SignIn).getContext(),Main2Activity.class);
            Toast.makeText(com.example.root.tableandparkingbookingathotel.SignUp.this, "Successsssl", Toast.LENGTH_LONG).show();

            //send the email add to nxt activity
            //intent.putExtra("emailInput",userEmail);

            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(findViewById(R.id.SignIn).getContext(),SignUp.class);
            //send the email add to nxt activity
            //intent.putExtra("emailInput",userEmail);
            startActivity(intent);
            Toast.makeText(com.example.root.tableandparkingbookingathotel.SignUp.this, "Invalid password or email", Toast.LENGTH_LONG).show();

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
