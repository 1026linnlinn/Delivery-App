package com.mounts.lenovo.delivery3.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mounts.lenovo.delivery3.R;

public class ServiceHolder extends RecyclerView.ViewHolder {

    private OnItemClickListener listener;
    private TextView texttitle, textprice, btnbook, btnsave;
    private ImageView imgView;

    public ServiceHolder(@NonNull View itemView, OnItemClickListener listener) {

        super(itemView);
        this.listener = listener;
    }

    public static ServiceHolder create(LayoutInflater inflater, ViewGroup parent, ServiceHolder.OnItemClickListener listener) {

        View view = inflater.inflate(R.layout.layout_card_horizontal, parent, false);
        return new ServiceHolder(view, listener);
    }

    public static void bindData() {
    }

    public interface OnItemClickListener {


    }


}