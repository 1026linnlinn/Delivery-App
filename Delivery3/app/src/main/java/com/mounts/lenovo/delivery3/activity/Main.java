package com.mounts.lenovo.delivery3.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.google.android.material.navigation.NavigationView;
import com.mounts.lenovo.delivery3.R;
import com.mounts.lenovo.delivery3.fragment.CategoriesFragment;
import com.mounts.lenovo.delivery3.fragment.MapFragment;
import com.mounts.lenovo.delivery3.fragment.ReceiverOrderFragment;

import static android.view.View.VISIBLE;

public class Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("hey", "Main now!");
        setContentView(R.layout.activity_main2);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setVisibility(View.GONE);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("RestrictedApi")
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_receive) {
            toolbar.setVisibility(VISIBLE);
            setFragment(new ReceiverOrderFragment());
        }
        else if (id == R.id.nav_send) {
            toolbar.setVisibility(VISIBLE);
            setFragment(new ReceiverOrderFragment());
        }
        else if (id == R.id.nav_map) {
            toolbar.setVisibility(View.GONE);
            setFragment(new MapFragment());
        }
        else if (id == R.id.nav_categories) {
            toolbar.setVisibility(VISIBLE);
            setFragment(new CategoriesFragment());
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void setFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();

    }

}
