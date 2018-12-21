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

import static com.example.a59050316.subj.R.layout.activity_notgeneralsublist;

public class notgeneralsublist extends AppCompatActivity {
    ImageView backgn;
    private ListView listview;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;
    public Integer count1;
    public int sumcount;
    private String uid;

    private ArrayList<String> name3=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_notgeneralsublist);
        getSupportActionBar().hide();
        backgn=(ImageView)findViewById(R.id.backbtgn);
        listview = (ListView) findViewById(R.id.itemnotlistgen);
        backgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        uid = user.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("StudentInform").child(uid).child("SubID").orderByChild("ID").startAt("90").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                count1 = 0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    String key1 = snapshot.getKey();
                    count1++;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databaseReference.child("StudentInform").child(uid).child("NotStudy").orderByChild("ID").startAt("90").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(count1>=10)sumcount=0;
                else if(count1<10) {
                    int count = 0;
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        String key = snapshot.getKey();
                        String value1 = snapshot.child("Name").getValue(String.class);
                        name3.add(count, key + "  " + value1);
                        count++;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview2, name3);
        listview.setAdapter(adapter);
    }
}
