package com.zyron.assetstudio.activities;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.zyron.assetstudio.databinding.ActivityIconLauncherBinding;
import com.zyron.assetstudio.R;
import android.view.View;
import android.graphics.Color;

import com.google.android.material.slider.Slider;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;

import com.zyron.assetstudio.fragments.ClipartIconFragment;
import com.zyron.assetstudio.fragments.TextIconFragment;
import com.zyron.assetstudio.fragments.ImageIconFragment;

public class IconLauncherActivity extends AppCompatActivity {

  private ActivityIconLauncherBinding binding;
  private FragmentManager fragmentManager;
  private Slider iconPadding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityIconLauncherBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    setSupportActionBar(binding.toolbar);
    setTitle("Launcher Icon");
    binding.toolbar.setNavigationOnClickListener((v) -> onBackPressed());
    fragmentManager = getSupportFragmentManager();
    MaterialButtonToggleGroup toggleGroup = findViewById(R.id.toggleButton);

    toggleGroup.check(R.id.clipartIcon);
    Fragment fragment = new ClipartIconFragment();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.replace(R.id.fragmentContainer, fragment);
    transaction.commit();

    toggleGroup.addOnButtonCheckedListener(
        (group, checkedId, isChecked) -> {
          if (isChecked) {
            Fragment selectedFragment = null;
            if (checkedId == R.id.clipartIcon) {
              selectedFragment = new ClipartIconFragment();
            } else if (checkedId == R.id.textIcon) {
              selectedFragment = new TextIconFragment();
            } else if (checkedId == R.id.imageIcon) {
              selectedFragment = new ImageIconFragment();
            }

            if (selectedFragment != null) {

              FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
              fragmentTransaction.setCustomAnimations(
                  R.anim.enter_animation,
                  R.anim.exit_animation,
                  R.anim.enter_animation,
                  R.anim.exit_animation);
              fragmentTransaction.replace(R.id.fragmentContainer, selectedFragment);
              fragmentTransaction.commit();
            }
          }
        });
        
    }

}
