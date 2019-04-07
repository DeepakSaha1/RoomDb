package com.example.roomdb;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {UserModel.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase mUserDatabaseInstance;

    public abstract UserDao userDao();

    public static synchronized UserDatabase getInstance(Context context) {
        if (mUserDatabaseInstance == null) {
            mUserDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                    UserDatabase.class, "user_db")
                    .addCallback(roomCallback)
                    .fallbackToDestructiveMigration().build();
        }
        return mUserDatabaseInstance;
    }

    private static Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

//    private static class LoadPreExistingDataInDBAT extends AsyncTask<Void, Void, Void> {
//        private UserDao userDao;
//
//        public LoadPreExistingDataInDBAT(UserDatabase database) {
//            userDao = database.userDao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            userDao.insertUser(new UserModel("fullmetal", "abc@gmail.com"));
//            return null;
//        }
//    }

}
