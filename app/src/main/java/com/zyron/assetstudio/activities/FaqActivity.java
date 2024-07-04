package com.zyron.assetstudio.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.zyron.assetstudio.databinding.ActivityFaqBinding;
import com.zyron.assetstudio.R;

public class FaqActivity extends AppCompatActivity {
    
    private ActivityFaqBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFaqBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        setTitle("FAQs");
        binding.toolbar.setNavigationOnClickListener((v) -> onBackPressed());
    }
}
