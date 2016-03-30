package com.zlatan.student.qrs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fs);
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        Button Button = (Button)findViewById(R.id.class_3b);
        Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FS.this, Roomlist.class);
                intent.putExtra("Room","3B");
                startActivity(intent);
            }
        });
        Button Button2 = (Button)findViewById(R.id.class_3c);

        Button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FS.this, Roomlist.class);
                intent.putExtra("Room","3C");
                startActivity(intent);
            }
        });
        Button Button3 = (Button)findViewById(R.id.class_4a);

        Button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FS.this, Roomlist.class);
                intent.putExtra("Room","4A");
                startActivity(intent);
            }
        });
        Button Button4 = (Button)findViewById(R.id.class_4b);

        Button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FS.this, Roomlist.class);
                intent.putExtra("Room", "4B");
                startActivity(intent);
            }
        });
    }
    }

