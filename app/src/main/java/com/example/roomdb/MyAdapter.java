package com.example.roomdb;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.roomdb.databinding.RowItemLayoutBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<UserModel> mUserModelList;
    private RowItemLayoutBinding mRowItemLayoutBinding;

    public void setmUserModelList(List<UserModel> mUserModelList) {
        this.mUserModelList = mUserModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mRowItemLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.row_item_layout, viewGroup, false);
        return new MyViewHolder(mRowItemLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        UserModel kUserModel = mUserModelList.get(i);
//        mRowItemLayoutBinding.setUser(userModel);  // Not working? Didn't know the reason!!
        mRowItemLayoutBinding.userEmail.setText(kUserModel.getUserEmail());
        mRowItemLayoutBinding.userName.setText(kUserModel.getUserName());
    }

    @Override
    public int getItemCount() {
        return mUserModelList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(RowItemLayoutBinding rowItemLayoutBinding) {
            super(rowItemLayoutBinding.getRoot());
        }
    }
}