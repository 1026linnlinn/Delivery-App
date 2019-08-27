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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.mounts.lenovo.delivery3.R;
import com.mounts.lenovo.delivery3.fragment.MapFragment;
import com.mounts.lenovo.delivery3.fragment.ReceiverOrderFragment;

import static android.view.View.VISIBLE;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private FloatingActionButton floatingActionButton;
    private FloatingSearchView mSearchView;
    private SearchView searchView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Log.e("hey", "Main now!");

        toolbar = findViewById(R.id.toolbar);
        toolbar.setVisibility(View.GONE);
//        floatingActionButton = findViewById(R.id.fab);
        mSearchView = findViewById(R.id.floating_search_view);
//        searchView = findViewById(R.id.searchView);

//        searchView.setQueryHint("Search View");
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                Toast.makeText(getBaseContext(), query, Toast.LENGTH_LONG).show();
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                Toast.makeText(getBaseContext(), newText, Toast.LENGTH_LONG).show();
//                return false;
//            }
//        });

//        setSupportActionBar(toolbar);

//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DrawerLayout drawer = findViewById(R.id.drawer_layout);
//                if (drawer.isDrawerOpen(GravityCompat.START)) {
//                    drawer.closeDrawer(GravityCompat.START);
//                } else {
//                    drawer.openDrawer(GravityCompat.START);
//                }
//            }
//        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        Log.e("MapFragment", "Arrive...");
        setFragment(new MapFragment());
        setupFloatingSearch();

    }

    private void setupFloatingSearch() {
//        mSearchView = findViewById(R.id.floating_search_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        mSearchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, final String newQuery) {
//                List<SearchSuggestion> list = new ArrayList<SearchSuggestion>();
//                //emulating search on dummy data
//                for (String item : SOME_HARDCODED_DATA) {
//                    if (item.contains(newQuery)) {
//                        list.add(new SimpleSuggestions(item));
//                    }
//                }
//                mSearchView.swapSuggestions(list);
            }
        });
        mSearchView.attachNavigationDrawerToMenuButton(drawerLayout);

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

        if (id == R.id.nav_receive) {
            toolbar.setVisibility(VISIBLE);
            mSearchView.setVisibility(View.GONE);
//            floatingActionButton.setVisibility(View.GONE);
            setFragment(new ReceiverOrderFragment());

        } else if (id == R.id.nav_send) {
            toolbar.setVisibility(VISIBLE);
            mSearchView.setVisibility(View.GONE);
//            floatingActionButton.setVisibility(View.GONE);
            setFragment(new ReceiverOrderFragment());

        } else if (id == R.id.nav_map) {
            toolbar.setVisibility(View.GONE);
            mSearchView.setVisibility(View.VISIBLE);
            mSearchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
                @Override
                public void onSearchTextChanged(String oldQuery, final String newQuery) {
                }
            });
            mSearchView.attachNavigationDrawerToMenuButton(drawerLayout);
            setFragment(new MapFragment());
        }
//
//        else if (id == R.id.nav_map) {
//            toolbar.setVisibility(View.GONE);
//            floatingActionButton.setVisibility(View.VISIBLE);
//            floatingActionButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    DrawerLayout drawer = findViewById(R.id.drawer_layout);
//                    if (drawer.isDrawerOpen(GravityCompat.START)) {
//                        drawer.closeDrawer(GravityCompat.START);
//                    } else {
//                        drawer.openDrawer(GravityCompat.START);
//                    }
//                }
//            });
//            setFragment(new MapFragment());
//        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void setFragment(Fragment fragment) {

//        toolbar.setVisibility(View.GONE);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container, fragment);
//        fragmentTransaction.commit();
    }
}
