package com.mounts.lenovo.delivery3.activity;

import android.os.Bundle;
import android.widget.Adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.mounts.lenovo.delivery3.R;
import com.mounts.lenovo.delivery3.adapter.ServiceAdapter;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class Categories extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ServiceAdapter serviceAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPage);
//        springDotsIndicator.setViewPager(mViewPager);

        ImageAdapter adapterView = new ImageAdapter(this);
        mViewPager.setAdapter(adapterView);
    }
}
