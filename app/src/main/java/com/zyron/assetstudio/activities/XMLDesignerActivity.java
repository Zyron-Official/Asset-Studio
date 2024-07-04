package com.zyron.assetstudio.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.zyron.assetstudio.databinding.ActivityXmldesignerBinding;
import com.zyron.assetstudio.R;

public class XMLDesignerActivity extends AppCompatActivity {
    
    private ActivityXmldesignerBinding binding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityXmldesignerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        setTitle("XML Designer");
        binding.toolbar.setNavigationOnClickListener((v) -> onBackPressed());
    }
}
