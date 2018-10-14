package com.rs.assignmenttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.rs.assignmenttest.models.EmployeesModel;

import java.util.List;

public class ListDetails extends AppCompatActivity {

   public RecyclerView listViews;
    EmployeesModel model = null;
    RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_details);
        listViews = findViewById(R.id.listViews);
        listViews.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        listViews.setLayoutManager(layoutManager);

        String values =  getIntent().getExtras().getString("jsonData");
        model = new Gson().fromJson(values, EmployeesModel.class);

        List<List<String>> data = model.getData();

        mAdapter = new DataAdapter(getApplicationContext(), data);
        listViews.setAdapter(mAdapter);


    }
}
