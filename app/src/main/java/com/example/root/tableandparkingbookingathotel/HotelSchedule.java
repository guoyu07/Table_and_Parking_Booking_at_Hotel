package com.example.root.tableandparkingbookingathotel;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class HotelSchedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_schedule);

//        Button HotelAvail = (Button) findViewById(R.id.button1);
//        HotelAvail.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                        Intent intent = new Intent(findViewById(R.id.button1).getContext(), HotelAvail.class);
//                        startActivity(intent);
//                    }
//                }
//        );
//        Button HotelBook = (Button) findViewById(R.id.button2);
//        HotelBook.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                        Intent intent = new Intent(findViewById(R.id.button2).getContext(), HotelBook.class);
//                        startActivity(intent);
//                    }
//                }
//        );
        init();
    }
    public void init() {
        TableLayout stk = (TableLayout) findViewById(R.id.table);
        TableRow tbrow0 = new TableRow(this);
        TextView tv0 = new TextView(this);
        tv0.setText(" Table NO ");
        tv0.setTextColor(Color.WHITE);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setText(" Customer Name ");
        tv1.setTextColor(Color.WHITE);
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText(" Check In ");
        tv2.setTextColor(Color.WHITE);
        tbrow0.addView(tv2);
        TextView tv3 = new TextView(this);
        tv3.setText(" Check Out ");
        tv3.setTextColor(Color.WHITE);
        tbrow0.addView(tv3);
        TextView tv4 = new TextView(this);
        tv4.setText(" Parking ");
        tv4.setTextColor(Color.WHITE);
        tbrow0.addView(tv4);
        stk.addView(tbrow0);
        for (int i = 0; i < 12; i++) {
            TableRow tbrow = new TableRow(this);
            TextView t1v = new TextView(this);
            t1v.setText("" + i);
            t1v.setTextColor(Color.WHITE);
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);
            TextView t2v = new TextView(this);
            t2v.setText("Product " + i);
            t2v.setTextColor(Color.WHITE);
            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);
            TextView t3v = new TextView(this);
            t3v.setText("Rs." + i);
            t3v.setTextColor(Color.WHITE);
            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);
            TextView t4v = new TextView(this);
            t4v.setText("" + i * 15 / 32 * 10);
            t4v.setTextColor(Color.WHITE);
            t4v.setGravity(Gravity.CENTER);
            tbrow.addView(t4v);
            stk.addView(tbrow);
        }
    }
}
