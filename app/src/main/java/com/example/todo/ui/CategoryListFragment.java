package com.example.todo.ui;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.todo.R;
import com.example.todo.db.Category;
import com.example.todo.viewmodel.CategoryViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CategoryListFragment extends BaseFragment {

    private CategoryViewModel mCategoryViewModel;

    public static final int NEW_CATEGORY_ACTIVITY_REQUEST_CODE = 1;

    public CategoryListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        // ページ遷移ボタンを取得
        Button button = view.findViewById(R.id.categoryToTask_Button);
        // fragment_task_list.xmlへ遷移
        button.setOnClickListener(v ->
                //画面遷移
                navigate(R.id.action_categoryListFragment_to_taskListFragment));

        // Add Categoryボタンを取得
        FloatingActionButton buttonAddCategory = view.findViewById(R.id.addCategory_Button);
        // dialogを表示
        buttonAddCategory.setOnClickListener(v -> {
            DialogFragment dialog = new CategoryDialog();
            dialog.show(getParentFragmentManager(), "CategoryDialog");
                });

        // RecyclerViewを取得
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        final CategoryListAdapter adapter = new CategoryListAdapter(new CategoryListAdapter.CategoryDiff());
        recyclerView.setAdapter(adapter);
        // TODO:動作確認
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        mCategoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        mCategoryViewModel.getCategories().observe(getViewLifecycleOwner(), categories -> {
            // Update the cached copy of the words in the adapter
            adapter.submitList(categories);
            });

    }
}