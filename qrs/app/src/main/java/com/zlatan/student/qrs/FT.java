package com.zlatan.student.qrs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ft);
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        Button Button = (Button) findViewById(R.id.class_8a);

        Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FT.this, Roomlist.class);
                intent.putExtra("Room", "8A");
                startActivity(intent);
            }
        });
        Button Button2 = (Button) findViewById(R.id.class_8b);

        Button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FT.this, Roomlist.class);
                intent.putExtra("Room", "8B");
                startActivity(intent);
            }
        });
        Button Button3 = (Button) findViewById(R.id.class_9a);

        Button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FT.this, Roomlist.class);
                intent.putExtra("Room", "9A");
                startActivity(intent);
            }
        });
        Button Button4 = (Button) findViewById(R.id.class_9b);

        Button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FT.this, Roomlist.class);
                intent.putExtra("Room", "9B");
                startActivity(intent);
            }
        });
        Button Button5 = (Button) findViewById(R.id.class_10a);

        Button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FT.this, Roomlist.class);
                intent.putExtra("Room", "10A");
                startActivity(intent);
            }
        });
        Button Button6 = (Button) findViewById(R.id.class_10b);

        Button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FT.this, Roomlist.class);
                intent.putExtra("Room", "10B");
                startActivity(intent);
            }
        });
        Button Button7 = (Button) findViewById(R.id.class_10c);

        Button7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FT.this, Roomlist.class);
                intent.putExtra("Room", "10C");
                startActivity(intent);
            }
        });
        Button Button8 = (Button) findViewById(R.id.sbr);
        Button8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FT.this, Roomlist.class);
                intent.putExtra("Room", "Smartboard Room");
                startActivity(intent);
            }
        });
    }}
