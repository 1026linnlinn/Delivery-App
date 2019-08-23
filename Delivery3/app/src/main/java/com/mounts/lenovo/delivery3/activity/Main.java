package com.mounts.lenovo.delivery3.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.mounts.lenovo.delivery3.R;
import com.mounts.lenovo.delivery3.fragment.GalleryFragment;
import com.mounts.lenovo.delivery3.fragment.HomeFragment;
import com.mounts.lenovo.delivery3.fragment.MapFragment;
import com.mounts.lenovo.delivery3.fragment.NewFragment;
import com.mounts.lenovo.delivery3.fragment.OrderFragment;
import com.mounts.lenovo.delivery3.fragment.ReceiverOrderFragment;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Log.e("hey", "Main now!");

        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        setFragment(new OrderFragment());
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.nav_home) {
            fragment = new HomeFragment();
            setFragment(fragment);
        } else if (id == R.id.nav_receive) {
            fragment = new ReceiverOrderFragment();
            setFragment(fragment);

        } else if (id == R.id.nav_send) {
            fragment = new ReceiverOrderFragment();
            setFragment(fragment);

        } else if (id == R.id.nav_main) {
            fragment = new OrderFragment();
            setFragment(fragment);

        } else if (id == R.id.nav_map) {

            fragment = new MapFragment();
            setFragment(fragment);

        } else if (id == R.id.nav_tools) {

            fragment = new GalleryFragment();
            setFragment(fragment);

        } else if (id == R.id.nav_share) {

            fragment = new NewFragment();
            setFragment(fragment);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
