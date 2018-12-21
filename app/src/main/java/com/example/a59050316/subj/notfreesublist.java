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

public class notfreesublist extends AppCompatActivity {
    ImageView backfr;
    private ListView listview;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;
    private String uid;

    private ArrayList<String> name3=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notfreesublist);
        getSupportActionBar().hide();
        backfr=(ImageView)findViewById(R.id.backbt);
        listview = (ListView) findViewById(R.id.itemnotlistfree);
        backfr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        uid = user.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("StudentInform").child(uid).child("NotStudy").orderByChild("ID").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int count=0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    String key = snapshot.getKey();
                    String value1 =snapshot.child("Name").getValue(String.class);
                    name3.add(count,key+"  "+value1);
                    count++;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ArrayAdapter adapter =new  ArrayAdapter<String>(this, R.layout.activity_listview2,name3);
        listview.setAdapter(adapter);
    }
}
