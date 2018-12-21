package com.example.a59050316.subj;


import android.content.Intent;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;


import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;



public class Kmitl2 extends AppCompatActivity {
    ImageButton bc,bp,bs;
    private TextView NmaeUs;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private String uid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kmitl21);
        getSupportActionBar().hide();
        bc=(ImageButton)findViewById(R.id.cousebt);
        bp=(ImageButton)findViewById(R.id.profilebt);
        bs=(ImageButton)findViewById(R.id.sumbt);
        NmaeUs=(TextView)findViewById(R.id.nameuser);

        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();

        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String User_N = dataSnapshot.child("StudentInform").child(uid).child("FName").getValue(String.class);
                String User_L = dataSnapshot.child("StudentInform").child(uid).child("LName").getValue(String.class);
                NmaeUs.setText(User_N+"   "+ User_L);
                Toast.makeText(Kmitl2.this,User_N,Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Kmitl2.this,"No have data",Toast.LENGTH_LONG).show();
            }
        });



        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Bc=new Intent(Kmitl2.this,couse3.class);
                startActivity(Bc);
            }
        });
        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Bp=new Intent(Kmitl2.this,Profile.class);
                startActivity(Bp);
            }
        });
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Bs=new Intent(Kmitl2.this,Summary.class);
                startActivity(Bs);
            }
        });


    }

}
