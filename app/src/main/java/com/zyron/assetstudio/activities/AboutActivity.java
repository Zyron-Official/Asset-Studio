package com.zyron.assetstudio.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.zyron.assetstudio.databinding.ActivityAboutBinding;
import com.zyron.assetstudio.R;

public class AboutActivity extends AppCompatActivity {
    private ActivityAboutBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        setTitle("About");
        binding.toolbar.setNavigationOnClickListener((v) -> onBackPressed());
    }
}
