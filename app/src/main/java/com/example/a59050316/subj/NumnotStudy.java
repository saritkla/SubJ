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

public class NumnotStudy extends AppCompatActivity {
    ImageView back;
    private TextView genn,fixn,freen,all;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private String uid;
    private int count1,count2,count3,count4;
    public String semana,project;
    private ArrayList<Integer> counal =new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numnotstudy);
        getSupportActionBar().hide();
        back=(ImageView)findViewById(R.id.backBTIDD);
        genn=(TextView) findViewById(R.id.gennot);
        fixn=(TextView) findViewById(R.id.fixnot);
        freen=(TextView) findViewById(R.id.freenot);
        all=(TextView)findViewById(R.id.nCountCadit);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        genn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Tgenlist=new Intent(NumnotStudy.this,notgeneralsublist.class);
                startActivity(Tgenlist);
            }
        });
        fixn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Tfixlist=new Intent(NumnotStudy.this,notfixsublist.class);
                startActivity(Tfixlist);
            }
        });
        freen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Tfreelist=new Intent(NumnotStudy.this,notfreesublist.class);
                startActivity(Tfreelist);
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


                genn.setText("ทั่วไป\n"+(30-count1));
                freen.setText("เสรี\n"+(6-count3));
                fixn.setText("เฉพาะ \n"+(100-count2));
                int a=count4;
                int ba=6-count3;
                if(semana.equals("0") && project.equals("0")){
                    if(ba<0){a=136-(a+ba);}
                    else a=136-a; }
                else if(!semana.equals("0") && project.equals("0")){
                    if(ba<0){a=136-(a+ba)+1;}
                    else a=136-a+1;}
                else if(semana.equals("0") && !project.equals("0")){
                    if(ba<0){a=136-(a+ba)+6;}
                    else a=136-a+6;}
                else if(!semana.equals("0") && !project.equals("0")){
                    if(ba<0){a=136-(a+ba)+7;}
                    else a=136-a+7;}
                all.setText(a+"\nหน่วย");



            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
