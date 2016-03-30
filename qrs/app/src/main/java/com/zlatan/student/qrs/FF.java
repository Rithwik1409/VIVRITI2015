package com.zlatan.student.qrs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ff);

        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        Button Button = (Button)findViewById(R.id.class_2a);

        Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FF.this, Roomlist.class);
                intent.putExtra("Room","2A");
                startActivity(intent);
            }
        });
        Button Button2 = (Button)findViewById(R.id.class_2b);

        Button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FF.this, Roomlist.class);
                intent.putExtra("Room","2B");
                startActivity(intent);
            }
        });
        Button Button3 = (Button)findViewById(R.id.class_2d);

        Button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FF.this, Roomlist.class);
                intent.putExtra("Room","2D");
                startActivity(intent);
            }
        });
        Button Button4 = (Button)findViewById(R.id.class_3b);

        Button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FF.this, Roomlist.class);
                intent.putExtra("Room","3B");
                startActivity(intent);
            }
        });
        Button Button5 = (Button)findViewById(R.id.class_3c);

        Button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FF.this, Roomlist.class);
                intent.putExtra("Room","3C");
                startActivity(intent);
            }
        });

    }
}
