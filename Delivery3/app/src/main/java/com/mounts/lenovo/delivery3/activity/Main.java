package com.mounts.lenovo.delivery3.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.mounts.lenovo.delivery3.R;
import com.mounts.lenovo.delivery3.fragment.GalleryFragment;
import com.mounts.lenovo.delivery3.fragment.HomeFragment;
import com.mounts.lenovo.delivery3.fragment.MapFragment;
import com.mounts.lenovo.delivery3.fragment.NewFragment;
import com.mounts.lenovo.delivery3.fragment.OrderFragment;
import com.mounts.lenovo.delivery3.fragment.ReceiverOrderFragment;

import static android.view.View.VISIBLE;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Log.e("hey", "Main now!");

        toolbar = findViewById(R.id.toolbar);
        toolbar.setVisibility(View.GONE);
        floatingActionButton = findViewById(R.id.fab);
//        setSupportActionBar(toolbar);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.isDrawerOpen(GravityCompat.START);
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//        navigationView.setNavigationItemSelectedListener(this);
        setFragment(new MapFragment());

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressLint("RestrictedApi")
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            toolbar.setVisibility(VISIBLE);
            floatingActionButton.setVisibility(View.GONE);
            setFragment(new HomeFragment());

        } else if (id == R.id.nav_receive) {
            toolbar.setVisibility(VISIBLE);
            floatingActionButton.setVisibility(View.GONE);
            setFragment(new ReceiverOrderFragment());

        } else if (id == R.id.nav_send) {
            toolbar.setVisibility(VISIBLE);
            floatingActionButton.setVisibility(View.GONE);
            setFragment(new ReceiverOrderFragment());

        } else if (id == R.id.nav_map) {
            toolbar.setVisibility(View.GONE);
            floatingActionButton.setVisibility(View.VISIBLE);
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DrawerLayout drawer = findViewById(R.id.drawer_layout);
                    if (drawer.isDrawerOpen(GravityCompat.START)) {
                        drawer.closeDrawer(GravityCompat.START);
                    } else {
                        drawer.openDrawer(GravityCompat.START);
                    }
                }
            });
            setFragment(new MapFragment());
        } else if (id == R.id.nav_tools) {
            toolbar.setVisibility(VISIBLE);
            floatingActionButton.setVisibility(View.GONE);
            setFragment(new ReceiverOrderFragment());

        } else if (id == R.id.nav_share) {
            toolbar.setVisibility(VISIBLE);
            floatingActionButton.setVisibility(View.GONE);
            setFragment(new ReceiverOrderFragment());
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void setFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container, fragment);
//        fragmentTransaction.commit();
    }
}
