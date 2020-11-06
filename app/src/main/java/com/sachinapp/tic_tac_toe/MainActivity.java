package com.sachinapp.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //static final String button = "com.sachinapp.tic_tac_toe.buttonValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton2(View view)
    {
        Intent intent = new Intent(this, doublePlay.class);

        startActivity(intent);
    }

    public void onClickButton1(View view)
    {
        Button buttono = findViewById(R.id.buttonO);
        buttono.setVisibility(View.VISIBLE);

        Button buttonx = findViewById(R.id.buttonX);
        buttonx.setVisibility(View.VISIBLE);

    }

    public void onClickButtonO(View view)
    {

        Button buttono = findViewById(R.id.buttonO);
        buttono.setVisibility(View.INVISIBLE);

        Button buttonx = findViewById(R.id.buttonX);
        buttonx.setVisibility(View.INVISIBLE);

        Intent intent = new Intent(this, singlePlayO.class);

        startActivity(intent);
    }

    public void onClickButtonX(View view)
    {
        Button buttonx = findViewById(R.id.buttonX);
        buttonx.setVisibility(View.INVISIBLE);

        Button buttono = findViewById(R.id.buttonO);
        buttono.setVisibility(View.INVISIBLE);

        Intent intent = new Intent(this, singlePlay.class);

        startActivity(intent);
    }
}