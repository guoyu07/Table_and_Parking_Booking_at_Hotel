package com.example.root.tableandparkingbookingathotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HotelBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_book);

        Button submit_offer = (Button) findViewById(R.id.submit_offer);
        submit_offer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(findViewById(R.id.submit_offer).getContext(), HotelSchedule.class);
                        startActivity(intent);
                    }
                }
        );

    }
}
