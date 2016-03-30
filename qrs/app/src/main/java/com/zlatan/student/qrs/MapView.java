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

import java.util.Map;

public class MapView extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button Buffon = (Button)findViewById(R.id.button);

        Buffon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapView.this, FB.class);
                startActivity(intent);
            }
        });
        Button Button = (Button)findViewById(R.id.button2);

        Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapView.this, FG.class);
                startActivity(intent);
            }
        });
        Button Button2 = (Button)findViewById(R.id.button3);

        Button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapView.this, FF.class);
                startActivity(intent);
            }
        });
        Button Button3 = (Button)findViewById(R.id.button4
        );

        Button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapView.this, FS.class);
                startActivity(intent);
            }
        });
        Button Button4 = (Button)findViewById(R.id.button5);

        Button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapView.this, FT.class);
                startActivity(intent);
            }
        });
        Button Button5 = (Button)findViewById(R.id.button5);

        Button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapView.this, FT.class);

                startActivity(intent);
            }
        });
        Button F4 = (Button)findViewById(R.id.f4);
        F4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapView.this, F4.class);

                startActivity(intent);
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
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem settingsItem = menu.findItem(R.id.action_settings);
        settingsItem.setVisible(false);
        return false;
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
            Intent mainIntent = new Intent(MapView.this,Home.class);
            MapView.this.startActivity(mainIntent);
            MapView.this.finish();
        } else if (id == R.id.Map_View) {
            Intent mainIntent = new Intent(MapView.this,MapView.class);
            MapView.this.startActivity(mainIntent);
            MapView.this.finish();
        }
        else if (id == R.id.About) {
            Intent mainIntent = new Intent(MapView.this,AboutApp.class);
            MapView.this.startActivity(mainIntent);
            MapView.this.finish();
        }
        else if (id == R.id.Search_by_name) {
            Intent mainIntent = new Intent(MapView.this,ns1.class);
            MapView.this.startActivity(mainIntent);
            MapView.this.finish();
        }
        else if (id == R.id.ss) {
            Intent mainIntent = new Intent(MapView.this,Countanna.class);
            MapView.this.startActivity(mainIntent);
            MapView.this.finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
