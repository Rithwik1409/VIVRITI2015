package com.zlatan.student.qrs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb);
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        Button Button = (Button)findViewById(R.id.class_ma);

        Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FB.this, Roomlist.class);
                intent.putExtra("Room","Mini Auditorium");
                startActivity(intent);
            }
        });
        Button Button2 = (Button)findViewById(R.id.class_avr);

        Button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FB.this, Roomlist.class);
                intent.putExtra("Room","AV ROOM");
                startActivity(intent);
            }
        });
        Button Button3 = (Button)findViewById(R.id.class_cl);

        Button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FB.this, Roomlist.class);
                intent.putExtra("Room","Computer Lab");
                startActivity(intent);
            }
        });
        Button Button4 = (Button)findViewById(R.id.class_cr);

        Button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FB.this, Roomlist.class);
                intent.putExtra("Room","Chess Room");
                startActivity(intent);
            }
        });
    }
}
