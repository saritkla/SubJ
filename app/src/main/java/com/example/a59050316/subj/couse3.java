package com.example.a59050316.subj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

public class couse3 extends AppCompatActivity {
    LinearLayout Gen,Fix,Free;
    TextView txtarea;
    ImageView back;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_couse3);
        getSupportActionBar().hide();
        Gen=(LinearLayout)findViewById(R.id.generalID);
        Fix=(LinearLayout)findViewById(R.id.fixID);
        Free=(LinearLayout)findViewById(R.id.freeID);
        back=(ImageView)findViewById(R.id.homebuttonID);
        txtarea = (TextView) findViewById(R.id.text_couse);




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    JSONArray jArray = new JSONArray(readJSONFromAsset());
                        String name;// name of the country
                    name = jArray.getJSONObject(0).getString("storie");
                    txtarea.setText(name);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

//                finish();
            }
        });
//        Free.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent Tfree=new Intent(couse3.this,freesub.class);
//                startActivity(Tfree);
//            }
//        });
//        Gen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent gen=new Intent(couse3.this,generalsub.class);
//                startActivity(gen);
//            }
//        });
//        Fix.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent Tfix=new Intent(couse3.this,fixsub.class);
//                startActivity(Tfix);
//            }
//        });
    }
    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("storie.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
