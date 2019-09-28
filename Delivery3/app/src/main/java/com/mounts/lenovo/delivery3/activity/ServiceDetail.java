package com.mounts.lenovo.delivery3.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mounts.lenovo.delivery3.R;
import com.mounts.lenovo.delivery3.adapter.DetailsAdapter;
import com.mounts.lenovo.delivery3.adapter.ImageAdapter;
import com.mounts.lenovo.delivery3.api.ApiInterface;
import com.mounts.lenovo.delivery3.fragment.CategoriesFragment;
import com.mounts.lenovo.delivery3.holder.DetailsHolder;
import com.mounts.lenovo.delivery3.retrofit.RetrofitService;

public class ServiceDetail extends AppCompatActivity {

    private ImageView backarrow;
    private FragmentManager fragmentManager;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Arrive", "ServiceDetail.java");
        setContentView(R.layout.service_detail);
        backarrow = findViewById(R.id.backarrow_service_detail);
        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("clicked", "backarrow");
                finish();
            }
        });
    }

}
