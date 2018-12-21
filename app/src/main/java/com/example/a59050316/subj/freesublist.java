package com.example.a59050316.subj;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class freesublist extends AppCompatActivity {
    ImageView bbackfree;
    private ListView listview;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;
    public String semana,project;
    public Integer count1,count2,count3,count4=0;
    private String uid;
    private ArrayList<String> name2=new ArrayList<String>();
    private ArrayList<String> name3=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freesublist);
        getSupportActionBar().hide();
        listview=(ListView)findViewById(R.id.itemlistfree);
        bbackfree=(ImageView)findViewById(R.id.backbt1);
        bbackfree.setOnClickListener(new View.OnClickListener() {
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
                count3 = 0;
                int count0 = 0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    String key31 = snapshot.getKey();
                    count3++;
                    String key1 = snapshot.getKey();
                    String value1 = snapshot.child("Name").getValue(String.class);
                    String value2 = snapshot.child("Grade").getValue(String.class);
                    name2.add(count0, key1 + "  " + value1 + " Grade " + value2);
                    count0++;

                }
                if (semana.equals("0") && project.equals("0")) {
                    if (count1 > 10 && count2 < 31) {
                        count3 = count1 - 10;
                        while (count3>0) {
                            String a = name2.get(count1);
                            name3.add(a);
                            count1--;
                            count3--;
                        }

                    } else if (count2 > 31 && count1 < 10) {
                        count3 = count2 - 31;
                        while (count3 > 0) {
                            String b = name2.get(count2);
                            name3.add(b);
                            count2--;
                            count3--;
                        }

                    } else if (count1 > 10 && count2 > 31) {
                        while (count1-10>0){ String a = name2.get(count1);name3.add(a);count1--;}
                        while (count2-31>0){String b = name2.get(count2);name3.add(b);count2--;}
                    }
                }
                else if (!semana.equals("0") && project.equals("0")) {
                    if (count1 > 10 && count2 < 32) {
                        count3 = count1 - 10;
                        while (count3 > 0) {
                            String a = name2.get(count1);
                            name3.add(a);
                            count1--;
                            count3--;
                        }

                    } else if (count2 > 32 && count1 < 10) {
                        count3 = count2 - 32;
                        while (count3 > 0) {
                            String b = name2.get(count2);
                            name3.add(b);
                            count2--;
                            count3--;
                        }

                    } else if (count1 > 10 && count2 > 32) {
                            while (count1-10>0){ String a = name2.get(count1);name3.add(a);count1--;}
                            while (count2-32>0){String b = name2.get(count2);name3.add(b);count2--;}
                    }
                }
                else if (semana.equals("0") && !project.equals("0")) {
                    if (count1 > 10 && count2 < 37) {
                        count3 = count1 - 10;
                        while (count3 > 0) {
                            String a = name2.get(count1);
                            name3.add(a);
                            count1--;
                            count3--;
                        }

                    } else if (count2 > 37 && count1 < 10) {
                        count3 = count2 - 37;
                        while (count3 > 0) {
                            String b = name2.get(count2);
                            name3.add(b);
                            count2--;
                            count3--;
                        }

                    } else if (count1 > 10 && count2 > 37) {
                        while (count1-10>0){ String a = name2.get(count1);name3.add(a);count1--;}
                        while (count2-37>0){String b = name2.get(count2);name3.add(b);count2--;}
                    }
                }
                else if (!semana.equals("0") && !project.equals("0")) {
                    if (count1 > 10 && count2 < 38) {
                        count3 = count1 - 10;
                        while (count3 > 0) {
                            String a = name2.get(count1);
                            name3.add(a);
                            count1--;
                            count3--;
                        }

                    } else if (count2 > 38 && count1 < 10) {
                        count3 = count2 - 38;
                        while (count3 > 0) {
                            String b = name2.get(count2);
                            name3.add(b);
                            count2--;
                            count3--;
                        }

                    } else if (count1 > 10 && count2 > 38) {

                        while (count1-10>0){ String a = name2.get(count1);name3.add(a);count1--;}
                        while (count2-38>0){String b = name2.get(count2);name3.add(b);count2--;}
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
