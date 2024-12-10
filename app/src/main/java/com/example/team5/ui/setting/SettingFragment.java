package com.example.team5.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.team5.databinding.FragmentSettingBinding;
import com.example.team5.ui.setting.compare.RelativeActivity;
import com.example.team5.ui.setting.compare.LinearActivity;

public class SettingFragment extends Fragment {

    private FragmentSettingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSettingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonBefore.setOnClickListener(view -> {
            startActivity(new Intent(requireActivity(), LinearActivity.class));
        });
        binding.buttonAfter.setOnClickListener(view -> {
            startActivity(new Intent(requireActivity(), RelativeActivity.class));
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
