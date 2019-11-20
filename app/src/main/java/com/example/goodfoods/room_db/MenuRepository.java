package com.example.goodfoods.room_db;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class MenuRepository {

    private Context mContext;

    public MenuRepository(Context mContext) {
        this.mContext = mContext;
    }

    public void getMenu(Callback callback){
        GetTask getTask = new GetTask(mContext,callback);
        getTask.execute();

    }
    public void insertMenu(menu item, InsertCallback callback){
        InsertTask insrInsertTask = new InsertTask(mContext,callback);
        insrInsertTask.execute(item);
    }

    public void deleteMenu(deleteCallback callback){
        DeleteTask deleteTask = new DeleteTask(mContext,callback);
        deleteTask.execute();

    }

    private static class GetTask extends AsyncTask<Void , Void , List<menu>> {

        private Context mContext;
        private Callback mCallback;

        public GetTask(Context context, Callback callback){
            this.mContext = context;
            this.mCallback = callback;
        }

        @Override
        protected List<menu> doInBackground(Void... voids) {
            AppDatabase db = AppDatabase.getInstance(mContext);
            List<menu> itemList = db.menuDAO().getAll();
            return itemList;
        }

        @Override
        protected void onPostExecute(List<menu> menuItem) {

            super.onPostExecute(menuItem);
            mCallback.onGetFood(menuItem);
        }
    }

    public interface Callback {
        void onGetFood(List<menu> itemList);
    }


    private static class InsertTask extends AsyncTask<menu,Void,Void > {

        private Context mContext;
        private InsertCallback mCallback;
        public InsertTask(Context context, InsertCallback callback){
            this.mContext = context;
            this.mCallback=callback;
        }



        @Override
        protected Void doInBackground(menu... ledgerItems) {
            AppDatabase db = AppDatabase.getInstance(mContext);
            db.menuDAO().insert(ledgerItems[0]);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mCallback.onInsertSuccess();

        }
    }

    public interface InsertCallback{
        void onInsertSuccess();
    }



    private static class DeleteTask extends AsyncTask<Void,Void,Void > {

        private Context mContext;
        private deleteCallback mCallback;
        public DeleteTask(Context context, deleteCallback callback){
            this.mContext = context;
            this.mCallback= callback;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mCallback.deleteMenu();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            AppDatabase db = AppDatabase.getInstance(mContext);
            db.menuDAO().deleteAll();
            return null;
        }
    }

    public interface deleteCallback {
        void deleteMenu();
    }



}
