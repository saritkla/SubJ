package com.example.a59050316.subj;

import android.annotation.SuppressLint;
import android.graphics.PostProcessor;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.snapshot.ChildKey;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class generalsublist extends AppCompatActivity {
    ImageView bback;
    private ListView listview;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;
    private String uid;
    private ArrayList<String> name2=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generalsublist);
        getSupportActionBar().hide();
        bback = (ImageView) findViewById(R.id.backbtgn1);
        listview = (ListView) findViewById(R.id.listitem);
        bback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        uid = user.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("StudentInform").child(uid).child("SubID").orderByChild("ID").startAt("90").limitToFirst(10).addValueEventListener(new ValueEventListener() {
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
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.activity_listview2, name2);
        listview.setAdapter(adapter);

    }
}
