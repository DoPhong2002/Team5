package com.example.team5.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.team5.databinding.FragmentSettingBinding;
import com.example.team5.ui.setting.relativelayout.AfterOptimizationActivity;
import com.example.team5.ui.setting.relativelayout.BeforeOptimizationActivity;

public class SettingFragment extends Fragment {

    private FragmentSettingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingViewModel settingViewModel =
                new ViewModelProvider(this).get(SettingViewModel.class);

        binding = FragmentSettingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonBefore.setOnClickListener(view -> {
            startActivity(new Intent(requireActivity(), AfterOptimizationActivity.class));
        });
        binding.buttonAfter.setOnClickListener(view -> {
            startActivity(new Intent(requireActivity(), BeforeOptimizationActivity.class));
        });

        final TextView textView = binding.textSetting;
        settingViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
