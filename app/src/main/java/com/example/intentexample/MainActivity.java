package com.example.intentexample;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1=findViewById(R.id.button);
        EditText ed1=findViewById(R.id.edURL);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(ed1.getText().toString());
                Intent i = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);

            }
        });

        Button b2=findViewById(R.id.button2);
        EditText ed2=findViewById(R.id.edPhone);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:"+ed2.getText().toString());
                Intent i = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(i);

            }
        });

        Button b3=findViewById(R.id.button3);
        EditText ed3=findViewById(R.id.edLocation);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Uri uri = Uri.parse("geo:0,0?q="+ed3.getText().toString());
                Intent i = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);

            }
        });

        Button b4=findViewById(R.id.button4);
        EditText ed4=findViewById(R.id.edText);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareCompat.IntentBuilder
                        .from(MainActivity.this)
                        .setType("text/plain")
                        .setText(ed4.getText().toString())
                        .startChooser();

            }
        });

    }
}