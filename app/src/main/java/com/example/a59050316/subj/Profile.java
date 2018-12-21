package com.example.a59050316.subj;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;

import java.io.InputStream;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile extends AppCompatActivity {
    ImageView Bh;
    private TextView nameusers,Ide,facuty,major,year;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private StorageReference datastore;
    private String uid;
    public String Im;
    private de.hdodenhof.circleimageview.CircleImageView Uimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
        Bh=(ImageView)findViewById(R.id.backhome);
        Bh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        nameusers=(TextView)findViewById(R.id.name_pro);
        Ide=(TextView)findViewById(R.id.Id_pro);
        facuty=(TextView)findViewById(R.id.Fac_pro);
        major=(TextView)findViewById(R.id.Ma_pro);
        year=(TextView)findViewById(R.id.Ye_pro);

        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String U_N = dataSnapshot.child("StudentInform").child(uid).child("FName").getValue(String.class);
                String U_L = dataSnapshot.child("StudentInform").child(uid).child("LName").getValue(String.class);
                String U_id = dataSnapshot.child("StudentInform").child(uid).child("ID").getValue(String.class);
                String U_fac = dataSnapshot.child("StudentInform").child(uid).child("Faculty").getValue(String.class);
                String U_ma = dataSnapshot.child("StudentInform").child(uid).child("Major").getValue(String.class);
                String U_year = dataSnapshot.child("StudentInform").child(uid).child("StudyYear").getValue(String.class);
                nameusers.setText(U_N+"   "+ U_L);
                Ide.setText(U_id);
                facuty.setText(U_fac);
                major.setText(U_ma);
                year.setText(U_year);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 String on = dataSnapshot.child("StudentInform").child(uid).child("image").getValue(String.class);
                new DownloadImageTask((de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.profile_image))
                        .execute(on);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        de.hdodenhof.circleimageview.CircleImageView bmImage;

        public DownloadImageTask(de.hdodenhof.circleimageview.CircleImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}

