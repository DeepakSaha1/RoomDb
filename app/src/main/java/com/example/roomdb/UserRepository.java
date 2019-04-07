package com.example.roomdb;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class UserRepository {

    private LiveData<List<UserModel>> mUserList;
    private UserDao mUserDao;

    public UserRepository(Context context) {
        UserDatabase userDatabase = UserDatabase.getInstance(context.getApplicationContext());
        mUserDao = userDatabase.userDao();
        mUserList = mUserDao.getAllUsers();
    }

    public LiveData<List<UserModel>> getmUserList() {
        return mUserList;
    }

    public void insertUser(UserModel user) {
        new InsertUserAT(mUserDao).execute(user);
    }

    public void deleteAllUsers() {
        new DeleteAllUsersAT(mUserDao).execute();
    }

    private static class InsertUserAT extends AsyncTask<UserModel, Void, Void> {
        private UserDao userDao;

        public InsertUserAT(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(UserModel... userModels) {
            userDao.insertUser(userModels[0]);
            return null;
        }
    }

    private static class DeleteAllUsersAT extends AsyncTask<Void, Void, Void> {
        private UserDao kUserDao;

        public DeleteAllUsersAT(UserDao userDao) {
            this.kUserDao = userDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            kUserDao.deleteAllUsers();
            return null;
        }
    }

}
