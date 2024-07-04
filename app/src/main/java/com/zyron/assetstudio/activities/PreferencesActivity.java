package com.zyron.assetstudio.activities;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.zyron.assetstudio.databinding.ActivityPreferencesBinding;
import com.zyron.assetstudio.R;

import androidx.fragment.app.Fragment;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import android.content.SharedPreferences;

import com.zyron.assetstudio.fragments.PreferencesFragment;
import com.zyron.assetstudio.activities.AboutActivity;

import com.zyron.assetstudio.R;

import java.util.Objects;

public class PreferencesActivity extends AppCompatActivity {
    private ActivityPreferencesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPreferencesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        setTitle("Preferences");
        binding.toolbar.setNavigationOnClickListener((v) -> onBackPressed());
    
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.fragmentContainer, new PreferencesFragment())
        .commit();
  
    }   
    
}
