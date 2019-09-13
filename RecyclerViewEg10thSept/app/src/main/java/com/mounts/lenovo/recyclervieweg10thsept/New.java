package com.mounts.lenovo.recyclervieweg10thsept;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import static android.view.View.VISIBLE;

public class New extends AppCompatActivity implements View.OnClickListener, SeeAllHolder.OnItemClickListener {

    SeeAllAdapter adapter;
    private Toolbar toolbar;

    @SuppressLint("WrongConstant")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.see_all_list);
        setContentView(R.layout.see_all_recycler_view);
        RecyclerView my_recycler_view = findViewById(R.id.seeall_recyclerview);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setVisibility(VISIBLE);

        adapter = new SeeAllAdapter(this);
        my_recycler_view.setHasFixedSize(true);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

    }
}
