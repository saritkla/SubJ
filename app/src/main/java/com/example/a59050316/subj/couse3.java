package com.example.a59050316.subj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class couse3 extends AppCompatActivity {
    LinearLayout Gen,Fix,Free;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_couse3);
        getSupportActionBar().hide();
        Gen=(LinearLayout)findViewById(R.id.generalID);
        Fix=(LinearLayout)findViewById(R.id.fixID);
        Free=(LinearLayout)findViewById(R.id.freeID);
        back=(ImageView)findViewById(R.id.homebuttonID);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Tfree=new Intent(couse3.this,freesub.class);
                startActivity(Tfree);
            }
        });
        Gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gen=new Intent(couse3.this,generalsub.class);
                startActivity(gen);
            }
        });
        Fix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Tfix=new Intent(couse3.this,fixsub.class);
                startActivity(Tfix);
            }
        });
    }
}
