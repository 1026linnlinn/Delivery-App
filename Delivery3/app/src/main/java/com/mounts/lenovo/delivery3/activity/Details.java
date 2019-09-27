package com.mounts.lenovo.delivery3.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.mounts.lenovo.delivery3.R;
import com.mounts.lenovo.delivery3.adapter.DetailsAdapter;
import com.mounts.lenovo.delivery3.adapter.SeeAllAdapter;
import com.mounts.lenovo.delivery3.api.ApiInterface;
import com.mounts.lenovo.delivery3.holder.DetailsHolder;
import com.mounts.lenovo.delivery3.holder.SeeAllHolder;
import com.mounts.lenovo.delivery3.retrofit.RetrofitService;

import retrofit2.Retrofit;

public class Details extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, DetailsHolder.OnItemClickListener {
    private RecyclerView recyclerView;
    DetailsAdapter detailsAdapter;
    RetrofitService retrofitService;
    private String token;
    private String sessionId;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Arrive", "Details.java");
        setContentView(R.layout.details);
        recyclerView = findViewById(R.id.my_recycler_view_details);
        detailsAdapter = new DetailsAdapter(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(detailsAdapter);
//        detail(sessionid);
    }

    private void detail(String sessionId) {
        ApiInterface apiInterface=retrofitService.getService().create(ApiInterface.class);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
