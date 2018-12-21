package com.example.a59050316.subj;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

import java.util.ArrayList;

public class NumStudy extends AppCompatActivity {
    ImageView back;
    private TextView Tlgen,Tlfix,Tlfree,all;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private String uid;
    public String semana,project;
    public Integer count1,count2,count3,count4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numstudy);
        getSupportActionBar().hide();
        back=(ImageView)findViewById(R.id.backBTID);
        Tlgen=(TextView) findViewById(R.id.gen);
        Tlfix=(TextView) findViewById(R.id.fix);
        Tlfree=(TextView) findViewById(R.id.fre);
        all=(TextView)findViewById(R.id.CountCadit);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Tlgen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Tg=new Intent(NumStudy.this,generalsublist.class);
                startActivity(Tg);
            }
        });
        Tlfix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Tfx=new Intent(NumStudy.this,fixsublist.class);
                startActivity(Tfx);
            }
        });
        Tlfree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Tfe=new Intent(NumStudy.this,freesublist.class);
                startActivity(Tfe);
            }
        });
        user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        uid = user.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("StudentInform").child(uid).child("SubID").orderByChild("ID").startAt("90").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 count1=0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    String key = snapshot.getKey();
                    count1++;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databaseReference.child("StudentInform").child(uid).child("SubID").orderByChild("ID").startAt("05").endAt("90").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 count2=0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    String key21 = snapshot.getKey();
                    count2++;
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databaseReference.child("StudentInform").child(uid).child("COOP").child("Status").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 String coop= dataSnapshot.getValue(String.class);
                project=coop;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databaseReference.child("StudentInform").child(uid).child("SEMINAR").child("Status").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String seminar= dataSnapshot.getValue(String.class);
                semana=seminar;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        databaseReference.child("StudentInform").child(uid).child("SubID").orderByChild("ID").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                count3=0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    String key31 = snapshot.getKey();
                    count3++;
                }

                if(semana.equals("0") && project.equals("0")){
                    count3=count3*3;count2=count2*3;count1=count1*3;count4=count3;
                    if(count1>30&&count2<93){
                        count3=count1-30;
                        count1=count1-count3;

                    }
                    else if(count2>93&&count1<30){
                        count3=count2-93;
                        count2=count2-count3;
                    }
                    else if(count1>30&&count2>93){
                        count3=((count1-30)+(count2-93));
                        count2=count2-(count2-93);
                        count1=count1-(count1-30);

                    }
                    else count3=0;}

                    else if(!semana.equals("0") && project.equals("0")){
                    count3=(count3*3)+1;count2=(count2*3)+1;count4=count3;
                    if(count1>30&&count2<94){
                        count3=count1-30;
                        count1=count1-count3;
                    }
                    else if(count2>94&&count1<30){
                        count3=count2-94;
                        count2=count2-count3;
                    }
                    else if(count1>30&&count2>94){
                        count3=((count1-30)+(count2-94));
                        count2=count2-(count2-94);
                        count1=count1-(count1-30);

                    }
                    else count3=0;
                }
                else if(semana.equals("0") && !project.equals("0")){
                    count3=(count3*3)+6;count2=(count2*3)+6;count4=count3;
                    if(count1>30&&count2<99){
                        count3=count1-30;
                        count1=count1-count3;
                    }
                    else if(count2>99&&count1<30){
                        count3=count1-99;
                        count2=count2-count3;
                    }
                    else if(count1>30&&count2>99){
                        count3=(count1-30)+(count2-99);
                        count2=count2-(count2-99);
                        count1=count1-(count1-30);

                    }
                    else count3=0;}
                else if(!semana.equals("0") && !project.equals("0")){
                    count3=(count3*3)+1+6;count2=(count2*3)+6+1;count4=count3;
                    if(count1>30&&count2<100){
                        count3=count1-30;
                        count1=count1-count3;
                    }
                    else if(count2>100&&count1<30){
                        count3=count1-100;
                        count2=count2-count3;
                    }
                    else if(count1>30&&count2>100){
                        count3=(count1-30)+(count2-100);
                        count2=count2-(count2-100);
                        count1=count1-(count1-30);

                    }
                    else count3=0;
                }
                    if(count3>6) Toast.makeText(NumStudy.this,"YOUR SUBJECT FREESUB ARE OVERLOAD",Toast.LENGTH_LONG).show();

                Tlgen.setText("ทั่วไป\n"+count1);
                Tlfree.setText("เสรี\n"+count3);
                Tlfix.setText("เฉพาะ \n"+count2);
                int a=count4;
                int ba=6-count3;
                if(semana.equals("0") && project.equals("0")){
                    if(ba<0){a=a+ba;}
                    else a=count4;
                }
                else if(!semana.equals("0") && project.equals("0")){
                    if(ba<0){a=(a+ba)+1;}
                    else a=a+1;}
                else if(semana.equals("0") && !project.equals("0")){
                    if(ba<0){a=(a+ba)+6;}
                    else a=a+6;}
                else if(!semana.equals("0") && !project.equals("0")){
                    if(ba<0){a=(a+ba)+7;}
                    else a=a+7;}
                all.setText(a+"\nหน่วย");



        }
        @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
