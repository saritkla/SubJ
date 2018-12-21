package com.example.a59050316.subj;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class fixsublist extends AppCompatActivity {
    ImageView bbackfix;
    private FirebaseUser user;
    private ListView listview;
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;
    private String uid;
    public String semana,project;
    public Integer count1,count2,count3,count4;
    private ArrayList<String> name2=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixsublist);
        getSupportActionBar().hide();
        listview =(ListView)findViewById(R.id.itemlistfix);
        bbackfix=(ImageView)findViewById(R.id.backbtfx1);
        bbackfix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        uid = user.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("StudentInform").child(uid).child("SubID").orderByChild("ID").startAt("05").endAt("90").limitToFirst(31).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int count=0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    String key1 = snapshot.getKey();
                    String value1 =snapshot.child("Name").getValue(String.class);
                    String value2 =snapshot.child("Grade").getValue(String.class);
                    name2.add(count,key1+"  "+value1+" Grade "+value2);
                    count++;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ArrayAdapter adapter =new  ArrayAdapter<String>(this, R.layout.activity_listview2,name2);
        listview.setAdapter(adapter);
    }
}
