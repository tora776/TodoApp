package com.example.todo.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.todo.R;

public class CategoryListFragment extends BaseFragment {

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
        // ボタンを取得
        Button button = view.findViewById(R.id.categoryToTask_Button);
        // fragment_task_list.xmlへ遷移
        button.setOnClickListener(v ->
                //画面遷移
                navigate(R.id.action_categoryListFragment_to_taskListFragment));
    }

}