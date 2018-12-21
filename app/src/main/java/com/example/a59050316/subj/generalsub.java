package com.example.a59050316.subj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class generalsub extends AppCompatActivity {
    ImageView backbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generalsub);
        getSupportActionBar().hide();
        backbt=(ImageView)findViewById(R.id.backBTID);
        backbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
