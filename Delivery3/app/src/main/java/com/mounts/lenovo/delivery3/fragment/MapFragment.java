package com.mounts.lenovo.delivery3.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.mounts.lenovo.delivery3.R;
import com.mounts.lenovo.delivery3.activity.NextOrder;

import static android.view.View.VISIBLE;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button btnNextOrder;
    private FloatingSearchView floatingSearchView;

    public MapFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e("MapFragment", "Arrive");
        final View view = inflater.inflate(R.layout.acitivity_map_fragment, container, false);
        btnNextOrder = view.findViewById(R.id.btnNextOrder);
        floatingSearchView = view.findViewById(R.id.floating_search_view);
        DrawerLayout drawerLayout = view.findViewById(R.id.drawer_layout);
//        NavigationView navigationView = view.findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
        floatingSearchView.attachNavigationDrawerToMenuButton(drawerLayout);

        btnNextOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Click", "btn");
                Intent intent = new Intent(getActivity(), NextOrder.class);
                startActivity(intent);
            }
        });
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        SupportMapFragment fragment = new SupportMapFragment();
        transaction.add(R.id.map, fragment);
        transaction.commit();
        fragment.getMapAsync(this);

        return view;

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menu) {
//        // Handle navigation view item clicks here.
//        int id = menu.getItemId();
//
//        if (id == R.id.nav_receive) {
//            floatingSearchView.setVisibility(View.GONE);
//            setFragment(new ReceiverOrderFragment());
//
//        } else if (id == R.id.nav_send) {
//            floatingSearchView.setVisibility(View.GONE);
//            setFragment(new ReceiverOrderFragment());
//
//        } else if (id == R.id.nav_map) {
//            floatingSearchView.setVisibility(VISIBLE);
//            setFragment(new ReceiverOrderFragment());
////            setFragment(new MapFragment());
//        }
//        return true;
//    }
//
//    private void setFragment(ReceiverOrderFragment receiverOrderFragment) {
//        getFragmentManager().beginTransaction().replace(R.id.frame_map, receiverOrderFragment).commit();
//    }
}
