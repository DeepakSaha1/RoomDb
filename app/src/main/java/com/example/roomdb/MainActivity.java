package com.example.roomdb;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.example.roomdb.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MainActivity extends AppCompatActivity {

    private MyViewModel mMyViewModel;
    private ActivityMainBinding mActivityMainBinding;
    private MyAdapter mMyAdapter;
    private List<UserModel> mUserModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mMyViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        mMyViewModel.getUsersVM().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(@Nullable List<UserModel> userModels) {
                mMyAdapter.setmUserModelList(userModels);
                mMyAdapter.notifyDataSetChanged();
            }
        });

        mMyAdapter = new MyAdapter();
        mUserModel = new ArrayList<>();
        mMyAdapter.setmUserModelList(mUserModel);
        mActivityMainBinding.recyclerView.setAdapter(mMyAdapter);
        mActivityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mActivityMainBinding.addUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyViewModel.insertUserVM(new UserModel("fullmetal", "abc@def.com"));
            }
        });

        mActivityMainBinding.clearDbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyViewModel.deleteAllUsersVM();
                mMyAdapter.notifyDataSetChanged();
            }
        });
    }
}
