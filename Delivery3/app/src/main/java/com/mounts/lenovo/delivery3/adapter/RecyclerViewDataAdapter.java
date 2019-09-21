package com.mounts.lenovo.delivery3.adapter;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mounts.lenovo.delivery3.R;
import com.mounts.lenovo.delivery3.activity.Details;
import com.mounts.lenovo.delivery3.activity.List;
import com.mounts.lenovo.delivery3.activity.Login;
import com.mounts.lenovo.delivery3.activity.Main;
import com.mounts.lenovo.delivery3.fragment.SeeAllFragment;

import java.util.ArrayList;

public class RecyclerViewDataAdapter extends RecyclerView.Adapter<RecyclerViewDataAdapter.ItemRowHolder> {

    private ArrayList<SectionDataModel> dataList;
    private Context mContext, context;

    public RecyclerViewDataAdapter(Context context, ArrayList<SectionDataModel> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Log.e("right here", "ok");
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);

        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder itemRowHolder, int i) {

        final String sectionName = dataList.get(i).getHeaderTitle();

        ArrayList singleSectionItems = dataList.get(i).getAllItemsInSection();

        itemRowHolder.itemTitle.setText(sectionName);

        SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(mContext, singleSectionItems);

        itemRowHolder.recycler_view_list.setHasFixedSize(true);
        itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);

    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }


    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView itemTitle, seeall;

        protected RecyclerView recycler_view_list;


        public ItemRowHolder(View view) {
            super(view);

            this.itemTitle = (TextView) view.findViewById(R.id.header);
//            this.seeall = view.findViewById(R.id.seeAll_1);//if you clicked see all btn,show in toast||Log and intent to new class.
            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), itemTitle.getText(), Toast.LENGTH_SHORT).show();
                    mContext.startActivity(new Intent(mContext, Details.class));//Login to other class what I pass...
                    Log.e("clicked", "SeeAll");
                }
            });
        }
    }
}
