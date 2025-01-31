package com.example.todo.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todo.db.Category;
import com.example.todo.db.CategoryRepository;

import java.util.List;

public class CategoryViewModel extends AndroidViewModel {
    private CategoryRepository mRepository;
    private final LiveData<List<Category>> mCategories;
    // コンストラクタ
    public CategoryViewModel(Application application){
        super(application);
        mRepository = new CategoryRepository(application);
        mCategories = mRepository.getCategories();
    }
    // キャッシュされたカテゴリーのリストを返す。
    LiveData<List<Category>> getCategories(){ return mCategories; }
    // insertリポジトリのメソッドを呼び出すラッパーメソッド。insert()UIから実装がカプセル化される。
    public void insert(Category category){ mRepository.insert(category); }
}
