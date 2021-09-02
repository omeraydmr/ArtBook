package com.omeraydmr.artbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.omeraydmr.artbook.databinding.ActivityArtBinding;
import com.omeraydmr.artbook.databinding.ActivityMainBinding;

public class ArtActivity extends AppCompatActivity {

    private ActivityArtBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityArtBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void save(View view) {

    }

    public void selectImage(View view) {

    }
}