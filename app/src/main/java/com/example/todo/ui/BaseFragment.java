package com.example.todo.ui;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class BaseFragment extends Fragment {
    protected void navigate(int actionId){
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(actionId);
    }
}
