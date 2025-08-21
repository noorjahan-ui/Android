package com.example.toggle;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView i1,i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        i1=(ImageView) findViewById(R.id.imageView1);
        i2=(ImageView) findViewById(R.id.imageView2);
        i1.setOnClickListener(this);
        i2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if (v.getId()==R.id.imageView1){
            i1.setVisibility(View.GONE);
            i2.setVisibility(View.VISIBLE);
        }
        else {
            i2.setVisibility(View.GONE);
            i1.setVisibility(View.VISIBLE);
        }
    }
}