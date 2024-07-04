package com.zyron.assetstudio.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.zyron.assetstudio.activities.AboutActivity;
import com.zyron.assetstudio.R;

import java.util.Objects;

public class PreferencesFragment extends PreferenceFragmentCompat {

  @Override
  public void onCreatePreferences(Bundle bundle, String rootKey) {
    setPreferencesFromResource(R.xml.preferences, rootKey);

    Preference about = findPreference("about");
    if (about != null) {
      about.setOnPreferenceClickListener(
          preference -> {
            Intent intent = new Intent(requireActivity(), AboutActivity.class);
            startActivity(intent);
            return true;
          });
    }
  }
}