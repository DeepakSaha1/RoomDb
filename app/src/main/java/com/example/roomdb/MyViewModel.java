package com.example.roomdb;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MyViewModel extends AndroidViewModel {

    private LiveData<List<UserModel>> mUserList;
    private UserRepository mUserRepository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        mUserRepository = new UserRepository(application);
        mUserList = mUserRepository.getmUserList();
    }

    public void insertUserVM(UserModel userModel) {
        mUserRepository.insertUser(userModel);
    }

    public void deleteAllUsersVM() {
        mUserRepository.deleteAllUsers();
    }

    public LiveData<List<UserModel>> getUsersVM() {
        return mUserList;
    }
}
