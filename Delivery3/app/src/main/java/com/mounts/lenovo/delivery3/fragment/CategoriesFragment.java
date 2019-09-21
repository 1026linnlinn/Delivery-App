package com.mounts.lenovo.delivery3.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mounts.lenovo.delivery3.R;
import com.mounts.lenovo.delivery3.activity.Details;
import com.mounts.lenovo.delivery3.adapter.ImageAdapter;
import com.mounts.lenovo.delivery3.adapter.RecyclerViewDataAdapter;
import com.mounts.lenovo.delivery3.adapter.SectionDataModel;
import com.mounts.lenovo.delivery3.adapter.ServiceAdapter;
import com.mounts.lenovo.delivery3.adapter.SingleItemModel;
import com.mounts.lenovo.delivery3.holder.ServiceHolder;

import java.util.ArrayList;

public class CategoriesFragment extends Fragment implements View.OnClickListener, ServiceHolder.OnItemClickListener {
    ArrayList<SectionDataModel> allSampleData;
    ImageAdapter imageAdapter;
    private ServiceAdapter serviceAdapter;
    private ViewPager viewPager;
    private RecyclerView recyclerView;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("Categories", "Fragment");
        View view = inflater.inflate(R.layout.categories, container, false);

        viewPager = view.findViewById(R.id.viewPager);
        ImageAdapter adapterView = new ImageAdapter(getContext());

//      TODO: Image ko click yin Details.class co yout chin tr...

        viewPager.setAdapter(adapterView);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("viewPager", "success");
                if (position == viewPager.getAdapter().getCount()) {
                    Intent intent = new Intent(getActivity(), Details.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        allSampleData = new ArrayList<SectionDataModel>();
        createData();
        recyclerView = view.findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);
        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(getContext(), allSampleData);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void createData() {
        for (int i = 0; i <= 10; i++) {

            SectionDataModel dataModel = new SectionDataModel();
            dataModel.setHeaderTitle("Most Popular" + i);
            ArrayList<SingleItemModel> singleItemModels = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 10; j++) {
                singleItemModels.add(new SingleItemModel("Shop" + j));
            }
            dataModel.setAllItemsInSection(singleItemModels);
            allSampleData.add(dataModel);
        }
    }

    @Override
    public void onClick(View v) {

    }

//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//    }
//
//    @Override
//    public void onPageSelected(int position) {
//
//        Log.e("viewPager", "success");
//        if (position == viewPager.getAdapter().getCount()) {
//            Intent intent = new Intent(getContext(), Details.class);
//            startActivity(intent);
//        }
//
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//
//    }
}
