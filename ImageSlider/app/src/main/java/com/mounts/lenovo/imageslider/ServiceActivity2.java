package com.mounts.lenovo.imageslider;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ServiceActivity2 extends AppCompatActivity implements ServiceHolder.OnItemClickListener {

    private RecyclerView recyclerView;
    private ServiceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service2);
        initActivity();
    }

    private void initActivity() {

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ServiceAdapter(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}
