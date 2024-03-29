package com.journaldev.androidrecyclerviewdatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.journaldev.androidrecyclerviewdatabinding.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CustomClickListener{

    private ActivityMainBinding binding;

    //https://www.journaldev.com/23989/android-recyclerview-data-binding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(linearLayoutManager);

        populateData();
    }

    private void populateData() {
        List<DataModel> dataModelList = new ArrayList<>();

        dataModelList.add(new DataModel("Android Oreo", "8.1"));
        dataModelList.add(new DataModel("Android Pie", "9.0"));
        dataModelList.add(new DataModel("Android Nougat", "7.0"));
        dataModelList.add(new DataModel("Android Marshmallow", "6.0"));

      //  binding.recyclerView.setAdapter(new MyRecyclerViewAdapter(dataModelList, this));

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(this,dataModelList, this);

        binding.setMyAdapter(myRecyclerViewAdapter);
    }

    @Override
    public void cardClicked(DataModel f) {
        Toast.makeText(this, "You clicked " + f.androidName,
                Toast.LENGTH_LONG).show();
    }
}
