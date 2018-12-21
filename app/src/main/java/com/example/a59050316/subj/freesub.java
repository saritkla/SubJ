package com.example.a59050316.subj;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class freesub extends AppCompatActivity {
    ImageView backcouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freesub);
        getSupportActionBar().hide();
        backcouse=(ImageView)findViewById(R.id.bbkk);
        backcouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
    }
}
