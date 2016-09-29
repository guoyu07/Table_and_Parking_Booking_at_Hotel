package com.example.root.tableandparkingbookingathotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HotelOrCust extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_or_cust);

        Button hotel_login_button = (Button) findViewById(R.id.hotel_login_button);
        hotel_login_button.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {

                        Intent intent = new Intent(findViewById(R.id.hotel_login_button).getContext(),HotelLogin.class);
                        startActivity(intent);
                    }
                }
        );

        Button customer_login_button = (Button) findViewById(R.id.customer_login_button);
        customer_login_button.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {

                        Intent intent = new Intent(findViewById(R.id.customer_login_button).getContext(),CustomerLogin.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
