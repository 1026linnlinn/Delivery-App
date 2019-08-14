package com.example.lenovo.delivery.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.delivery.R;
import com.example.lenovo.delivery.holder.NewHolder;

public class NewAdapter extends RecyclerView.Adapter<NewHolder> {
    private String [] mDataset;
    NewHolder.OnItemClickListener listener;

    public NewAdapter(NewHolder.OnItemClickListener listener){

        this.listener = listener;
    }

    @NonNull
    @Override
    public NewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return NewHolder.create(inflater,viewGroup,listener);
//        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listdata,viewGroup,false);
//        return new ViewHolder(view);
//        ...
//        MyViewHolder vh = new MyViewHolder(v);
//        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull NewHolder newHolder, int i) {

        NewHolder.bindData();

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
