package com.example.root.tableandparkingbookingathotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String userEmail;


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

                        final EditText email = (EditText) findViewById(R.id.email);
                        userEmail = email.getText().toString();

                        Intent intent = new Intent(findViewById(R.id.SignIn).getContext(),Main2Activity.class);
                        //send the email add to nxt activity
                        intent.putExtra("emailInput",userEmail);

                        startActivity(intent);
                    }
                }
        );
//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(
//                new View.OnClickListener()
//                {
//                    @Override
//                    public void onClick(View view)
//                    {
//
//                        final EditText emailpass = (EditText) findViewById(R.id.email);
//                        userEmail = emailpass.getText().toString();
//
//                        Intent intent = new Intent(findViewById(R.id.button).getContext(),HomePage.class);
//                        //send the email add to nxt activity
//                        intent.putExtra("emailInput",userEmail);
//
//                        startActivity(intent);
//                    }
//                }
//        );
    }
}
