package com.zlatan.student.qrs;

import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;

import com.parse.Parse;


public class Splashscreen extends Activity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splashscreen);
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "l1Fr4NUycNPWEzCmhbUNJfeGn6ETcTwzNzAgoekh", "Di47u3r8wpDNGUAMWVI26X5PEKFQuqLLQHLVkj20");



        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        SharedPreferences pref = getSharedPreferences("MyPref", MODE_PRIVATE);
        pref.getBoolean("Userid", false);
        final Boolean Userid = pref.getBoolean("Userid", false);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("back","back");
        editor.commit();
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                if (Userid==false){
                      Intent cat = new Intent(Splashscreen.this,Login.class);
                    startActivity(cat);
                    finish();


                }
                else {Intent i = new Intent(Splashscreen.this,Home.class);
                    startActivity(i);
                    finish();
                }
            }

        }, SPLASH_DISPLAY_LENGTH);

    }
}