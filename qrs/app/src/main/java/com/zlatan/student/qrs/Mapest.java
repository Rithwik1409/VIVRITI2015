package com.zlatan.student.qrs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;

public class Mapest extends AppCompatActivity {

    EditText editText;
    public static TextView textViewObj;
    public static TextView TextViewObj2;
    Bundle extras;
    TextView Student;
    Button button;
    EditText feedback;

    TextView Project;
    TextView Location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sbn);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        Student = (TextView) findViewById(R.id.textView8);
        Project = (TextView) findViewById(R.id.textView7);
        Location = (TextView) findViewById(R.id.textView9);
        final String UserName = pref.getString("key_name", "");
        final RatingBar mBar = (RatingBar) findViewById(R.id.ratingBar2);
        final float a = (mBar.getRating());
        Intent intent = getIntent();
        final String item = intent.getStringExtra("selected-item");
        Student.setText("");
        Project.setText(item);
        Location.setText("");
        feedback = (EditText)findViewById(R.id.editText3);
        button=(Button)findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ParseObject testObject = new ParseObject("Viviv");
                String comments = feedback.getText().toString();
               // testObject.put("GroupMembers", item);
                testObject.put("UserName", UserName);
                testObject.put("StarRating", String.valueOf(mBar.getRating()));
                testObject.put("Comments", comments);
                testObject.put("Project", item);
                testObject.saveInBackground();
                Toast.makeText(getApplicationContext(), "Feedback recieved!! Thank you for your feedback",
                        Toast.LENGTH_LONG).show();
                Intent i = new Intent(Mapest.this, MapView.class);
                startActivity(i);
            }
        });
    }
}
