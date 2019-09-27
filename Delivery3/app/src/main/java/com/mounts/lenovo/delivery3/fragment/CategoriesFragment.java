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
    ViewPager viewPager;
    private RecyclerView recyclerView;
//    int images[] = {R.drawable.images1, R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,R.drawable.dishes};

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
//        adapterView = new ImageAdapter(getContext(), images);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        imageAdapter = new ImageAdapter(getActivity());
        viewPager.setAdapter(imageAdapter);

        recyclerView = view.findViewById(R.id.my_recycler_view);
        serviceAdapter = new ServiceAdapter(this);
        recyclerView.setAdapter(serviceAdapter);

        allSampleData = new ArrayList<SectionDataModel>();
        createData();


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

}
