package com.zlatan.student.qrs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseObject;

public class Rate extends AppCompatActivity {
String comments;
    Integer stars;
    RatingBar mBar;
    EditText et;
Button button;
TextView prname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences User = getSharedPreferences("User", MODE_PRIVATE);
        RatingBar mBar = (RatingBar) findViewById(R.id.ratingBar);
        final int numStars = mBar.getNumStars();
        final String UserName = User.getString("UserName", "");
        et = (EditText)findViewById(R.id.editText2);
        prname = (TextView) findViewById(R.id.prname);

        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ParseObject testObject = new ParseObject("Lilk");
                String comments = et.getText().toString();
                testObject.put("UserName", UserName);
                testObject.put("StarRating2", numStars);
                testObject.put("Comments", comments);
                testObject.saveInBackground();
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        Intent intent = getIntent();


        String item = intent.getStringExtra("selected-item");
prname.setText(item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

}
