package com.example.root.tableandparkingbookingathotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class HotelAvail extends AppCompatActivity {


    TextView t1;
    TextView t2;
    EditText in_hr ;
    EditText in_min ;
    EditText in_sec ;
    EditText out_hr ;
    EditText out_min ;
    EditText out_sec ;
    EditText date_year;
    EditText date_month;
    EditText date_date;
    String timein;
    String timeout;
    String hr ;
    String min;
    String sec ;
    String date , year , month , datecheck ;
    TextView get_availiable_no;

    public static final String JSON_URL = "http://10.42.0.82/avail1.php";

    public static  String KEY_NUM ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_avail);
        //init();

        in_hr = (EditText) findViewById(R.id.in_hr);
        in_min = (EditText) findViewById(R.id.in_min);
        in_sec = (EditText) findViewById(R.id.in_sec);
        out_hr = (EditText) findViewById(R.id.out_hr);
        out_min = (EditText) findViewById(R.id.out_min);
        out_sec = (EditText) findViewById(R.id.out_sec);
        date_year =(EditText) findViewById(R.id.date_year);
        date_month =(EditText) findViewById(R.id.date_month);
        date_date =(EditText) findViewById(R.id.date_date);

        get_availiable_no = (TextView)findViewById(R.id.get_availiable_no);

        t1=(TextView)findViewById(R.id.t1);

        t2=(TextView)findViewById(R.id.t2);

        Button get_availiable_button = (Button) findViewById(R.id.get_availiable_button);
        get_availiable_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        hr = in_hr.getText().toString();
                        min = in_min.getText().toString();
                        sec = in_sec.getText().toString();
                        timein = hr +":"+min+":"+sec ;

                        hr = out_hr.getText().toString();
                        min = out_min.getText().toString();
                        sec = out_sec.getText().toString();
                        timeout = hr +":"+min+":"+sec ;

                        year =date_year.getText().toString();
                        month =date_month.getText().toString();
                        date = date_date.getText().toString();
                        datecheck = date_year+"-"+date_month+"-"+date_date;

                        t1.setText(timein);
                        t2.setText(timeout);
                        sendRequest();

//                        Intent intent = new Intent(findViewById(R.id.get_availiable_button).getContext(), HotelSchedule.class);
//                        startActivity(intent);
                    }
                }
        );

        Button hotel_schedule = (Button) findViewById(R.id.button1);
        hotel_schedule.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(findViewById(R.id.button1).getContext(), HotelSchedule.class);
                        startActivity(intent);
                    }
                }
        );
        Button HotelBook = (Button) findViewById(R.id.button2);
        HotelBook.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(findViewById(R.id.button2).getContext(), HotelBook.class);
                        startActivity(intent);
                    }
                }
        );

    }
    private void sendRequest() {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("Response",response);
                        String str[]=response.split(";;");
                        showJSON(str[str.length-1]);
                        //showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(com.example.root.tableandparkingbookingathotel.HotelAvail.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                KEY_NUM="cin";
                params.put(KEY_NUM, timein);
                KEY_NUM="cout";
                params.put(KEY_NUM, timeout);
                KEY_NUM="date";
                params.put(KEY_NUM, datecheck);
                KEY_NUM="hemail";
                params.put(KEY_NUM, "t");

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
        get_availiable_no.setText(name1);
//        if (name1 == "1")
//        {
//            final EditText email = (EditText) findViewById(R.id.customer_email);
//            userEmail = email.getText().toString();
//
//            Intent intent = new Intent(findViewById(R.id.SignIn).getContext(),Main2Activity.class);
//            //send the email add to nxt activity
//            intent.putExtra("emailInput",userEmail);
//            Toast.makeText(com.example.root.tableandparkingbookingathotel.HotelLogin.this, "Successss", Toast.LENGTH_LONG).show();
//
//            startActivity(intent);
//        }
//        else
//        {
//            Intent intent = new Intent(findViewById(R.id.SignIn).getContext(),HotelLogin.class);
//            //send the email add to nxt activity
//            //intent.putExtra("emailInput",userEmail);
//            startActivity(intent);
//            Toast.makeText(com.example.root.tableandparkingbookingathotel.HotelLogin.this, "Invalid password or email", Toast.LENGTH_LONG).show();
//
//        }

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
