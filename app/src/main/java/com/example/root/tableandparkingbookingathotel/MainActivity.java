package com.example.root.tableandparkingbookingathotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button SignIn = (Button) findViewById(R.id.SignIn);
        SignIn.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        Intent intent = new Intent(findViewById(R.id.SignIn).getContext(),HomePage.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
