package com.zyron.assetstudio.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.zyron.assetstudio.databinding.ActivityShapeshifterBinding;
import com.zyron.assetstudio.R;

public class ShapeShifterActivity extends AppCompatActivity {

    private ActivityShapeshifterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShapeshifterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        setTitle("Shape Shifter");
        binding.toolbar.setNavigationOnClickListener((v) -> onBackPressed());
    }
}
