package com.example.lenovo.delivery.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.delivery.R;

public class NewHolder extends RecyclerView.ViewHolder {

    private OnItemClickListener listener;
    private TextView txt1,txt2,txt3;
    private Button btn;

    public NewHolder(@NonNull View itemView, OnItemClickListener listener) {
        super(itemView);
        this.listener = listener;
        txt1 = itemView.findViewById(R.id.text1);
        txt2 = itemView.findViewById(R.id.text2);
        txt3 = itemView.findViewById(R.id.text3);
        btn = itemView.findViewById(R.id.btn);
    }

    public static NewHolder create(LayoutInflater inflater, ViewGroup viewGroup, NewHolder.OnItemClickListener listener) {

        View view = inflater.inflate(R.layout.layout_fragment_layout, viewGroup , false);
        Log.e("holder","success");
        return new NewHolder(view,listener);

    }

    public static void bindData() {
    }

    public interface OnItemClickListener {
    }
}
