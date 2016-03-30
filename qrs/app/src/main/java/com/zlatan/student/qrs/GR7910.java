package com.zlatan.student.qrs;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GR7910 extends AppCompatActivity {

    String time1="11-11-2015 6:15:00";
    String gr1 = "00-00-0000 0:00:00";


    TextView tv;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView annap;
    String new_string;
    String time2="20-11-2015 09:00:00";
    String tim[]={"20-11-2015 09:00:00","20-11-2015 09:35:00","20-11-2015 10:10:00","20-11-2015 10:45:00","20-11-2015 12:30:00","20-11-2015 13:05:00","20-11-2015 13:40:00","20-11-2015 14:10:00" };
    //GR10&9&7
    String Gr10[]={"20-11-2015 09:00:00","20-11-2015 09:50:00","20-11-2015 10:40:00","20-11-2015 11:30:00", "20-11-2015 11:50:00", "20-11-2015 12:50:00","20-11-2015 13:40:00", "20-11-2015 14:10:00"};
    String Gr8[]={"20-11-2015 09:00:00","20-11-2015 10:00:00","20-11-2015 11:00:00","20-11-2015 12:00:00","20-11-2015 13:00:00","20-11-2015 14:00:00"};
    Bundle extras;
    String dim[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gr7910);
        annap=(TextView)findViewById(R.id.tvtv);
        tv=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);
        tv3=(TextView)findViewById(R.id.textView3);
        tv4=(TextView)findViewById(R.id.textView4);
        tv5=(TextView)findViewById(R.id.tv5);
        Intent intent = getIntent();
        //final String morn =

        final Handler handler = new Handler();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Calendar start = Calendar.getInstance();
                String time = "dd-MM-yyyy hh:mm:ss"; // 12:00
                String dateStart =(String) DateFormat.format(time, start);
                String dateStop = time2;
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                java.util.Date ds=null;
                java.util.Date dsto=null;
                java.util.Date d1= null;
                java.util.Date d2=null;
                java.util.Date d3=null;
                java.util.Date d4=null;
                java.util.Date d5=null;
                java.util.Date d6=null;
                java.util.Date d7=null;
                java.util.Date d8=null;
                try {
                    ds = format.parse(dateStart);
                    d1 = format.parse(Gr10[0]);
                    d2 = format.parse(Gr10[1]);
                    d3 = format.parse(Gr10[2]);
                    d4 = format.parse(Gr10[3]);
                    d5 = format.parse(Gr10[4]);
                    d6 = format.parse(Gr10[5]);
                    d7 = format.parse(Gr10[6]);
                    d8 = format.parse(Gr10[7]);
                    dsto=d1;
                    if(ds.getTime()-d1.getTime()>0){
                        dsto=d2;
                    }
                    if(ds.getTime()-d2.getTime()>0){
                        dsto=d3;
                    }
                    if(ds.getTime()-d3.getTime()>0){
                        dsto=d4;
                    }
                    if(ds.getTime()-d4.getTime()>0){
                        dsto=d5;
                    }
                    if(ds.getTime()-d5.getTime()>0){
                        dsto=d6;
                    }
                    if(ds.getTime()-d6.getTime()>0){
                        dsto=d7;
                    } if(ds.getTime()-d7.getTime()>0){
                        dsto=d8;
                    }




                    // if(d2.getTime()-d1.getTime()==0){
                    //   d2=format.parse(tim[i+1]);
                    // i=i+1;
                    //}
                } catch (java.text.ParseException e) {

                    e.printStackTrace();
                }
                long diff = dsto.getTime() - ds.getTime();

                long diffdays =(diff/ (1000*60*60*24));
                long diffHours = ((diff - (1000*60*60*24*diffdays)) / (1000*60*60));
                long diffMinutes = (diff - (1000*60*60*24*diffdays) - (1000*60*60*diffHours)) / (1000*60);
                long diffSeconds =(diff - (1000*60*60*24*diffdays) - (1000*60*60*diffHours) -(1000*60*diffMinutes))/ (1000);


                if (diffdays<0){diffdays=0;}
                if (diffHours<0){diffHours=0;}
                if (diffMinutes<0){diffMinutes=0;}
                if (diffSeconds<0){diffSeconds=0;}
                String Days=" "+ diffdays;
                String Hours = " :"+diffHours;

                String Minutes =" :"+diffMinutes;
                String Seconds = " :"+diffSeconds;

                String Finished = "";
                if (diffdays==0 & diffHours==0 & diffMinutes==0 & diffSeconds==0)

                {Finished="Final Show Ended... Please come back next year.";}
                else {Finished = "";}

                tv5.setText(Finished);
                tv.setText(Days + " Days");
                tv2.setText(Hours + " Hours");
                tv3.setText(Minutes + " Minutes");
                tv4.setText(Seconds + " Seconds");

                handler.postDelayed(this, 1000);
            }
        }, 1000);
    }
}
