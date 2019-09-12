package com.mounts.lenovo.delivery3.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mounts.lenovo.delivery3.holder.NewHolder;

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
