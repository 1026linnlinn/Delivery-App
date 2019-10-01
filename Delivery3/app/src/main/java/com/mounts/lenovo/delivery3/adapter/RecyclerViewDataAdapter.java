package com.mounts.lenovo.delivery3.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mounts.lenovo.delivery3.activity.List;
import com.mounts.lenovo.delivery3.api.OnItemClickListener;
import com.mounts.lenovo.delivery3.holder.ItemRowHolder;
import com.mounts.lenovo.delivery3.response.GetServiceList;

import java.util.ArrayList;

public class RecyclerViewDataAdapter extends RecyclerView.Adapter<ItemRowHolder> {

    private List<GetServiceList> getServiceList1 = new List<>();
    private Context mContext;
    private OnItemClickListener listener;

    public RecyclerViewDataAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Log.e("right here", "ok");
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return ItemRowHolder.create(inflater, viewGroup, listener);
    }

    public void onBindViewHolder(@NonNull ItemRowHolder holder, int position) {
        holder.bindData(getServiceList1.get(position));

    }

    @Override
    public int getItemCount() {
        return getServiceList1.size();
//        return (null != dataList ? dataList.size() : 0);
    }

    public void addData(List<GetServiceList> getServiceListList) {
        if (this.getServiceList1.size() == 0) {
            this.getServiceList1 = getServiceListList;
        } else getServiceList1.addAll(getServiceListList);
        notifyDataSetChanged();
    }

}
//TODO: to check adapter and holder ...linn
//
//public class MedicineAdapter extends RecyclerView.Adapter<MedicineHolder> {
//
//    private List<MedicineData> medicineData = new ArrayList<>();
//    private OnItemClickListener listener;
//
//    public MedicineAdapter(OnItemClickListener listener){
//        this.listener = listener;
//    }
//
//    @NonNull
//    @Override
//    public MedicineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        return MedicineHolder.create(inflater, parent, listener);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MedicineHolder holder, int position) {
//        holder.bindData(medicineData.get(position));
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return medicineData.size();
//    }
//
//    public void addData(List<MedicineData> medicineData) {
//        if (this.medicineData.size() == 0) {
//            this.medicineData = medicineData;
//        } else medicineData.addAll(medicineData);
//        notifyDataSetChanged();
//    }
//
//}