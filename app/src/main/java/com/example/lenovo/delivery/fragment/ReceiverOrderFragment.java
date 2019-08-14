package com.example.lenovo.delivery.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.delivery.R;
import com.example.lenovo.delivery.adapter.NewAdapter;
import com.example.lenovo.delivery.holder.NewHolder;
import com.example.lenovo.delivery.holder.NewHolder.OnItemClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReceiverOrderFragment extends Fragment implements View.OnClickListener, OnItemClickListener {
    private RecyclerView recyclerView;
    NewAdapter adapter;
    private TextView txt1, txt2, txt3, btn;
    private Button btnTrack;


    public ReceiverOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receiver_order, container, false);
        Log.e("YouReachReceiverOrder", "success");
        recyclerView = view.findViewById(R.id.recyclerView);
        txt1 = view.findViewById(R.id.text1);
        txt2 = view.findViewById(R.id.text2);
        txt3 = view.findViewById(R.id.text3);
        btnTrack = view.findViewById(R.id.btnTrack);

//        txt1.setOnClickListener(this);
//        txt2.setOnClickListener(this);
//        txt3.setOnClickListener(this);
//        btn.setOnClickListener(this);

        adapter = new NewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;

    }

    @Override
    public void onClick(View v) {

    }
}
