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

import com.parse.Parse;
import com.parse.ParseObject;

public class fivest extends AppCompatActivity {

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
        Student = (TextView) findViewById(R.id.textView8);
        Project = (TextView) findViewById(R.id.textView7);
        Location = (TextView) findViewById(R.id.textView9);

        Intent intent = getIntent();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);

        final String UserName = pref.getString("key_name", "");
        final RatingBar mBar = (RatingBar) findViewById(R.id.ratingBar2);
        final float a = (mBar.getRating());
        final int numStars =(int)a;
        feedback = (EditText)findViewById(R.id.editText3);
        // fetch value from key-value pair and make it visible on TextView.
        final String item = intent.getStringExtra("Members");
        final String item2 = intent.getStringExtra("Project");
        final String item3 = intent.getStringExtra("Location");
        Student.setText(item);
        Project.setText(item2); Location.setText(item3);

       /* String new_string;
        String new_string2;


        extras = getIntent().getExtras();
        new_string = extras.getString("Project");
        extras = getIntent().getExtras();
        new_string2= extras.getString("Members");

        textViewObj = (TextView) findViewById(R.id.textView4);
        textViewObj.setText(new_string);
        TextViewObj2 = (TextView) findViewById(R.id.textView5);
        TextViewObj2.setText(new_string2);

        // Enable Local Datastore.
       // Parse.enableLocalDatastore(this);

        //Parse.initialize(this, "VQvxgQcoRnconltVbLysSEtqbX2ieMMqAunrPhDI", "vqqd6e3ApQyYuWZsZkrmHw4CWBIkpzLG2iTDV1bm");

        button=(Button)findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ParseObject testObject = new ParseObject("TestObject");

                testObject.put("Project Name", "");
                testObject.put("Group Members", "");
                testObject.put("Username", pref.getString("key_name", ""));
                testObject.put("Feedback", "");
                testObject.put("Stars","");

                testObject.saveInBackground();
            }
        });*/
        button=(Button)findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ParseObject testObject = new ParseObject("Viviv");
                String comments = feedback.getText().toString();
                testObject.put("GroupMembers", item);
                testObject.put("UserName", UserName);
                testObject.put("StarRating", String.valueOf(mBar.getRating()));
                testObject.put("Comments", comments);
                testObject.put("Project",item2 );
                testObject.saveInBackground();
                Toast.makeText(getApplicationContext(), "Feedback recieved!! Thank you for your feedback",
                        Toast.LENGTH_LONG).show();
                Intent i = new Intent(fivest.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
