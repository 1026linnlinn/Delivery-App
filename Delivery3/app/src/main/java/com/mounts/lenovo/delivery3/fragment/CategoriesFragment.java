package com.mounts.lenovo.delivery3.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mounts.lenovo.delivery3.R;
import com.mounts.lenovo.delivery3.activity.ImageAdapter;
import com.mounts.lenovo.delivery3.adapter.ServiceAdapter;
import com.mounts.lenovo.delivery3.holder.ServiceHolder;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment implements View.OnClickListener, ServiceHolder.OnItemClickListener {
    ImageAdapter imageAdapter;
    private ServiceAdapter serviceAdapter;
    private RecyclerView recyclerView;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("Categories", "Fragment");
        View view = inflater.inflate(R.layout.categories, container, false);
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.viewPage);
//        springDotsIndicator.setViewPager(mViewPager);

//        ImageAdapter adapterView = new ImageAdapter(getActivity());
        imageAdapter = new ImageAdapter(getActivity());
        recyclerView = view.findViewById(R.id.recyclerViewCategories);
        serviceAdapter = new ServiceAdapter(this);
        recyclerView.setAdapter(serviceAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mViewPager.setAdapter(imageAdapter);
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
