package com.zyron.assetstudio.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.zyron.assetstudio.databinding.ActivityAssetBinding;

public class AssetActivity extends AppCompatActivity {
    private ActivityAssetBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAssetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
