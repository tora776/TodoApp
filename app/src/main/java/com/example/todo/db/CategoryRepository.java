package com.example.todo.db;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CategoryRepository {
    private CategoryDao mCategoryDao;
    private LiveData<List<Category>> mCategories;

    // DBインスタンスを作成し、Category一覧を取得する
    public CategoryRepository(Application application){
        AppDatabase db = AppDatabase.getInstance(application);
        mCategoryDao = db.categoryDao();
        mCategories = mCategoryDao.getAll();
    }

    // Room からカテゴリーのリストを返す。
    public LiveData<List<Category>> getCategories(){
        return mCategories;
    }

    public void insert(Category category){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mCategoryDao.insert(category);
        });
    }
}
