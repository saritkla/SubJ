package com.example.a59050316.subj;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText pass;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        email=(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.password);
        firebaseAuth=FirebaseAuth.getInstance();
    }
    public void btlogin_Click(View v){
        final ProgressDialog progressDialog=ProgressDialog.show(MainActivity.this,"Please wait...","Processing...",true);

        (firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),pass.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this,"Login successful",Toast.LENGTH_LONG).show();
                            Intent i=new Intent(MainActivity.this,Kmitl2.class);
                            i.putExtra("Email",firebaseAuth.getCurrentUser().getEmail());
                            startActivity(i);
                        } else {
                            Log.e("Error",task.getException().toString());
                            Toast.makeText(MainActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

}
