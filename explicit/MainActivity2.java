package com.example.explicitintents;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView imageView = findViewById(R.id.imageViewCountry);

        String index = getIntent().getStringExtra("ImageIndex");
        if (index == null) index = "1";

        switch (index) {
            case "1":
                imageView.setImageResource(R.drawable.img1);
                break;
            case "2":
                imageView.setImageResource(R.drawable.img2);
                break;
            case "3":
                imageView.setImageResource(R.drawable.img3);
                break;
            case "4":
                imageView.setImageResource(R.drawable.img4);
                break;
            default:
                imageView.setImageResource(R.drawable.img1);
                break;
        }
    }
}
