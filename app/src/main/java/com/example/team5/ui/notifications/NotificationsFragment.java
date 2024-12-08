package com.example.team7.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.team7.databinding.FragmentNotificationsBinding;
import com.example.team7.ui.notifications.compare.CanvasActivity;
import com.example.team7.ui.notifications.compare.OpenGLActivity;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonBeforeNotifications.setOnClickListener(view -> {
            startActivity(new Intent(requireActivity(),  CanvasActivity.class));
        });

        binding.buttonAfterNotifications.setOnClickListener(view -> {
            startActivity(new Intent(requireActivity(),OpenGLActivity.class));
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}