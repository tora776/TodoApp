package com.example.todo.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.todo.R;

public class CategoryListFragment extends Fragment {

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

        Button button = view.findViewById(R.id.categoryToTask_Button);
        button.setOnClickListener(v -> {
            // NavControllerを取得
            // NavController navController = Navigation.findNavController(view);
            NavController navController = NavHostFragment.findNavController(CategoryListFragment.this);
            //画面遷移
            navController.navigate(R.id.action_categoryListFragment_to_taskListFragment);
        });
    }
}