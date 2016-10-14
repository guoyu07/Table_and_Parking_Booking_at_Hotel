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

        Button HotelSchedule = (Button) findViewById(R.id.button1);
        HotelSchedule.setOnClickListener(
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
}
