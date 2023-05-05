package com.example.wizzardcube.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.wizzardcube.R;
import com.example.wizzardcube.View.MainActivity5;

public class MainActivity8 extends AppCompatActivity {
    private ImageButton mReturn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main8);

        mReturn = findViewById(R.id.ReturnButton);

        mReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity5.class);
                startActivity(intent);
                finish();

            }
        });

    }
}