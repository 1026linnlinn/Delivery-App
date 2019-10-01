package com.mounts.lenovo.delivery3.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mounts.lenovo.delivery3.R;
import com.mounts.lenovo.delivery3.adapter.SectionListDataAdapter;
import com.mounts.lenovo.delivery3.api.OnItemClickListener;
import com.mounts.lenovo.delivery3.response.AddsOnServices;
import com.mounts.lenovo.delivery3.response.GetServiceList;

public class ItemRowHolder extends RecyclerView.ViewHolder implements OnItemClickListener {
    private TextView categoryName, seeAll;
    private RecyclerView recyclerViewCate;
    private OnItemClickListener listener;

    public ItemRowHolder(@NonNull View itemView, OnItemClickListener listener) {
        super(itemView);
        this.listener = listener;
        initHolder(itemView);
    }

    public static ItemRowHolder create(LayoutInflater inflater, ViewGroup viewGroup, OnItemClickListener listener) {
        View view = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new ItemRowHolder(view , listener);
    }

    private void initHolder(View itemView) {
        categoryName = itemView.findViewById(R.id.categoryName);
        seeAll = itemView.findViewById(R.id.seeAll_1);
        recyclerViewCate = itemView.findViewById(R.id.recycler_view_list);
    }

    public void bindData(final GetServiceList getServiceList) {
        categoryName.setText(getServiceList.cateName);
        LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        SectionListDataAdapter sectionListDataAdapter = new SectionListDataAdapter(this);
        recyclerViewCate.setAdapter(sectionListDataAdapter);
        recyclerViewCate.setLayoutManager(layoutManager);
        sectionListDataAdapter.addData(getServiceList.addsOnServices);
        seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(getServiceList.cateId);
            }
        });
    }

    @Override
    public void onItemClick(int id) {

    }
}
