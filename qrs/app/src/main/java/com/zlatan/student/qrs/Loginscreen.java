package com.zlatan.student.qrs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Loginscreen extends AppCompatActivity {
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    EditText editText;
    public static String obeseboo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
Log.d("Paper", "Itreachedoncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            EditText editText = (EditText) findViewById(R.id.editText);
             String obeseboo = editText.getText().toString();


            @Override
            public void onClick(View view) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("key_name", editText.getText().toString()); // Storing string





                editor.putBoolean("Userid", true);
                editor.putString("back", "");

                editor.commit();
                Intent mainIntent = new Intent(Loginscreen.this, Home.class);
                startActivity(mainIntent);

            }
        });

    }}



