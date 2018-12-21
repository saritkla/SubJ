package com.example.a59050316.subj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class fixsub extends AppCompatActivity {
    ImageView bbacktc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixsub);
        bbacktc=(ImageView)findViewById(R.id.backbtffx);
        bbacktc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
