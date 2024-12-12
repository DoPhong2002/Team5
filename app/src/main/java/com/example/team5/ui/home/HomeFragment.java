package com.example.team5.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.team5.databinding.FragmentHomeBinding;
import com.example.team5.ui.home.compare.FrameLayoutActivity;
import com.example.team5.ui.home.compare.MergeLayoutActivity;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonBeforeHome.setOnClickListener(view -> {
            startActivity(new Intent(requireActivity(), FrameLayoutActivity.class));
        });

        binding.buttonAfterHome.setOnClickListener(view -> {
            startActivity(new Intent(requireActivity(), MergeLayoutActivity.class));
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}