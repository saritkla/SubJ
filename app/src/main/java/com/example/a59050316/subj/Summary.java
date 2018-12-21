package com.example.a59050316.subj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Summary extends AppCompatActivity {
    ImageView Backhome;
    LinearLayout Finish,NFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        getSupportActionBar().hide();
        Backhome=(ImageView)findViewById(R.id.homesumbtID);
        Finish=(LinearLayout)findViewById(R.id.numfishID);
        NFinish=(LinearLayout)findViewById(R.id.numnotfishID);

        Backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Fn=new Intent(Summary.this,NumStudy.class);
                startActivity(Fn);
            }
        });
        NFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notF=new Intent(Summary.this,NumnotStudy.class);
                startActivity(notF);
            }
        });
    }
}
