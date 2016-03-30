package com.zlatan.student.qrs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.parse.ParseObject;


public class Countanna extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
Button button;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button11;
    Button button7;
    Button button8;
    Button button9;
    Button button10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countpapea);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        button7=(Button)findViewById(R.id.button7);
        button8=(Button)findViewById(R.id.button8);
        button9=(Button)findViewById(R.id.button9);
        button10=(Button)findViewById(R.id.button10);
       // button11=(Button)findViewById(R.id.button11);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent i = new Intent(Countanna.this, Countpape.class);

                i.putExtra("morn", "Arjun C, Samridhi, Johan, Prarthana, Mukul, Kaavyaa, Aahana R, Aadya, Puri Jagannath, Vishakha, Hamshini, Mihika, Gokul, Jasnavi, Riya, Sarvesh, Arjun P, Sharath, Amogh, Dhriti, Kyra, Rohith, Abhinav, Ansh, Samrath, Tanvi, Manasvi, Shravan, Vedanth, Manasvi, Tanvi, Johan");

                i.putExtra("aft", "Shreyas, Dheeyanksha, Vidyuth, Ananya Srinivasan, Krish, Aahana U, Meghna, Pranav, Anjali, Mahima, Ananya Srisailam, Yash, Pallavi, Srimathi, Ethan, Anika, Manya, Shresta, Nandita, Sharan, Uthkarsh, Ananya K, Shlok, Sakshi, Sidharth, Chandana, Ilina, Swapnil, Madhav N, Anika, Nandita, Ananya K");
                startActivity(i);}
        });
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent i = new Intent(Countanna.this, Countpape.class);

                i.putExtra("morn", "Pranav T., Suhanee, Siddharth, Prajwal, Sharvi, Akash, Pranav H, Zoyah, Lakshya, Akanksha, Advika, Bhavni, Irene, Rakshan, Aditya, Samanvay, Muskaan, Mehr, Ananya, Vibha, Esha, Pragna, Emily, Dakshin, Prathik, Aarav, Namya, Aashi, Piyush, Ruddhra, Tarush ");
                i.putExtra("aft", "Sameeksha, Kushi, Taanvi, Amoghavarsha, Ved, Kunal, Hamsini, Manya, Adarsh, Nihaar, Suman, Aditi, Varsha, Saqib, Sumukh, Elena,  Medha, Akshita, Shraddha, Taanvi, Dravya, Shloka, Kushi, Laksh, Sameeksha,  Sirish, Preetham, Sarah, Aashi, Pari, Suhani, Pawan, Tanusha ");
                startActivity(i);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent i = new Intent(Countanna.this, Countpape.class);

                i.putExtra("morn", "Manan, Mithil, Dhruv Ramasubban, Bhavin, Gaurav, Harshith, Nihaar, Mythri, Sai Charan, Avi, Harshita, Krisha, Vaishnavi, Trisha, Navya, Dhruv Deepak, Sahana, Poorvi, Sanskriti, Tanya Verma, Stuti, Yeshas, Poorvi, Tanya Verma, Nikita, Ritanya, Vaishnavi, Nikita");
                i.putExtra("aft", " Aathreya, Rishi,  Mervyn, Siddarth, Anikethan, Preryth, Ankit, Shourya, Ayush, Lekshmi, Sharvi, Punitha, Mridula, Kenisha, Akanksha, Amrit, Samiksha, Aarna, Sanika, Tanya Roy, Dharshita, Krish, Tanya Roy, Kashvi, Aarna, Sanika, Kenisha, Mridula");
                startActivity(i); }
        });
        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent i = new Intent(Countanna.this, Countpape.class);

                i.putExtra("morn", "Vignesh, Mrigaj, Krishna N, Tanuj, Siddharth, Harsh, Shreya K, Ananya, Saxena, Shaurya, Esanjo, Dinesh, Aarushi, Tishya, Gia, Ribhav, Aditya, Arav, Daksh, Akshat, Yashas, Disha, Dinesh, Akshat, Krishna.N, Ananya");
                i.putExtra("aft", "Shivang, Abhay, Sahil, Harsha, Krishna.S, Abhinav, Nidhi, Divya, Samaraditya, Anika, Shreyas, Pranav, Shrivali, Mihika, Darsh, Sourav, Hrishikesh, Dharshan, Rishab, Smayyan, Nihaal, Dharshan, Rishab, Shreyas, Nandana");
                startActivity(i);  }
        });
        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent i = new Intent(Countanna.this, Countpape.class);

                i.putExtra("morn", " Aritro, Sanjana K, Surabhi Reddy, Aadi, Aarav Sinha, Aarshi, Aarshia, Riddhibrata, Aarav A, Ravi, Rhea, Samraksh, Karan Goel, Shriya, Asija, Anggadh,  Raghhav,  Mahathi, Nandana, Angad B, Medha Mrityunjay, Mrinmayii, Dhruv, Tanya Suraj, Ansruta, Tarun, Nandika Keerthan, Mahathi, Rhea, Anushka");
                i.putExtra("aft","Ranjna K, Akshaya, Arin, Lakshmi, Ayesha, Surya, Rehan, Pradnyan, Disha R, Anshul R, Mayukh, Isha, Vignesh, Kunsh, Ananya J, Dipsmita, Chiranthan, Avni, Abhimanyu, Nirajit, Anshul B, Akul, Rianne, Shrikha, Aditi, Monal, Ananya J, Sravya, Disha, Arshe" );
                startActivity(i);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent i = new Intent(Countanna.this, GR7910.class);


                startActivity(i);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent i = new Intent(Countanna.this, Gr8.class);

                startActivity(i);
            }
            });
        button9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent i = new Intent(Countanna.this, GR7910.class);

                startActivity(i);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent i = new Intent(Countanna.this, GR7910.class);

                startActivity(i);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.countanna, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.Home) {
            Intent mainIntent = new Intent(Countanna.this,Home.class);
            Countanna.this.startActivity(mainIntent);
            Countanna.this.finish();  // Handle the camera action
        }
        else if (id == R.id.Map_View) {
            Intent mainIntent = new Intent(Countanna.this,MapView.class);
            Countanna.this.startActivity(mainIntent);
            Countanna.this.finish();
        }




        else if (id == R.id.Search_by_name) {
            Intent mainIntent = new Intent(Countanna.this,ns1.class);
            Countanna.this.startActivity(mainIntent);
            Countanna.this.finish();
        }
        else if (id == R.id.About) {
            Intent mainIntent = new Intent(Countanna.this,AboutApp.class);
            Countanna.this.startActivity(mainIntent);
            Countanna.this.finish();

        }
        else if (id == R.id.ss) {
            Intent mainIntent = new Intent(Countanna.this, Countanna.class);
            Countanna.this.startActivity(mainIntent);
            Countanna.this.finish();

        }
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
}
}
