package com.example.lenovo.delivery.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.delivery.R;
import com.example.lenovo.delivery.adapter.NewAdapter;
import com.example.lenovo.delivery.holder.NewHolder;
import com.example.lenovo.delivery.retrofit.RetrofitService;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewFragment extends Fragment implements NewHolder.OnItemClickListener {
    private RecyclerView recyclerView;
    private RetrofitService service;
    NewAdapter adapter;

    public NewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_new, container, false);
        initFragment(view);
        return view;

    }

    private void initFragment(View view) {

        recyclerView = view.findViewById(R.id.recyclerView);
        service = new RetrofitService();
        adapter = new NewAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

    }

}
