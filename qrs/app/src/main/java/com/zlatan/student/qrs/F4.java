package com.zlatan.student.qrs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class F4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f4);
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        Button Button = (Button)findViewById(R.id.class_6a);

        Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(F4.this, Roomlist.class);
                intent.putExtra("Room", "6A");
                startActivity(intent);
            }
        });
        Button Button2 = (Button)findViewById(R.id.class_6b);

        Button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(F4.this, Roomlist.class);
                intent.putExtra("Room","6B");
                startActivity(intent);
            }
        });
        Button Button3 = (Button)findViewById(R.id.class_6c);

        Button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(F4.this, Roomlist.class);
                intent.putExtra("Room","6C");
                startActivity(intent);
            }
        });
        Button Button4 = (Button)findViewById(R.id.class_7b);

        Button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(F4.this, Roomlist.class);
                intent.putExtra("Room","7B");
                startActivity(intent);
            }
        });
        Button Button5 = (Button)findViewById(R.id.class_7c);

        Button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(F4.this, Roomlist.class);
                intent.putExtra("Room","7C");
                startActivity(intent);
            }
        });
        Button Button6 = (Button)findViewById(R.id.fr);

        Button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(F4.this, Roomlist.class);
                intent.putExtra("Room","French Room");
                startActivity(intent);
            }
        });
    }
}