package com.zyron.assetstudio;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.Toolbar;
import static com.zyron.assetstudio.R.string;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.zyron.assetstudio.R;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.app.ActionBar;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatDelegate;
import android.widget.ImageButton;
import android.widget.CompoundButton;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import android.animation.Animator;
import android.content.res.Configuration;
import android.view.ViewAnimationUtils;
import android.content.SharedPreferences;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.zyron.assetstudio.activities.AboutActivity;
import com.zyron.assetstudio.activities.ShapeShifterActivity;
import com.zyron.assetstudio.activities.PreferencesActivity;
import com.zyron.assetstudio.activities.XMLDesignerActivity;
import com.zyron.assetstudio.activities.FaqActivity;
import com.zyron.assetstudio.activities.IconLauncherActivity;
import com.zyron.assetstudio.databinding.ActivityMainBinding;

import com.zyron.assetstudio.fragments.PreferencesFragment;

import com.google.android.material.navigation.NavigationView;
import android.content.pm.PackageManager;
import java.io.File;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DrawerLayout activityMain;
    private ConstraintLayout layoutMain;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private int selectedNavItem = R.id.navigation_home;
    private static MainActivity instance;
    private static final float END_SCALE = 0.7f;

    public static MainActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.layoutMain.toolbar);
        

        activityMain = binding.activityMain;
        navigationView = binding.navigationView;
        toolbar = binding.layoutMain.toolbar;
        layoutMain = findViewById(R.id.layoutMain);

    actionBarDrawerToggle =
        new ActionBarDrawerToggle(
            this,
            activityMain,
            binding.layoutMain.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close);

        navigationDrawer();
        animateNavigationDrawer();

        activityMain.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        
        final FloatingActionButton fabDraw = findViewById(R.id.fab_draw);
        binding.layoutMain.fabDraw.setOnClickListener(view -> {
            Intent intent = new Intent(this, IconLauncherActivity.class);
            startActivity(intent);
        });

    }

    private void navigationDrawer() {
    navigationView.bringToFront();
    navigationView.setCheckedItem(R.id.navigation_home);
    navigationView.setNavigationItemSelectedListener(
            item -> {
                int id = item.getItemId();
                if (id == R.id.navigation_home) {
                    activityMain.postDelayed(() -> {
                    activityMain.closeDrawer(GravityCompat.START);
                    }, 230);
                } else if (id == R.id.navigation_shapeshifter) {
                    activityMain.closeDrawer(GravityCompat.START);
                    activityMain.postDelayed(() -> {
                    startActivity(new Intent(this, ShapeShifterActivity.class));
                    }, 230);
                } else if (id == R.id.navigation_preferences) {
                    activityMain.closeDrawer(GravityCompat.START);
                    activityMain.postDelayed(() -> {
                    startActivity(new Intent(this, PreferencesActivity.class));
                    }, 230); 
                } else if (id == R.id.navigation_xmldesigner) {
                    activityMain.closeDrawer(GravityCompat.START);
                    activityMain.postDelayed(() -> {
                    startActivity(new Intent(this, XMLDesignerActivity.class));
                    }, 230);
                } else if (id == R.id.navigation_faq) {
                    activityMain.closeDrawer(GravityCompat.START);
                    activityMain.postDelayed(() -> {
                    startActivity(new Intent(this, FaqActivity.class));
                    }, 230);
                } else if (id == R.id.navigation_updates) {
                    openUrl();
                    activityMain.closeDrawer(GravityCompat.START);
                } else if (id == R.id.navigation_share) {
                    shareApp();
                    activityMain.closeDrawer(GravityCompat.START);
                }

                return true;
            });
}
    private void animateNavigationDrawer() {
    activityMain.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
            float diffScaledOffset = slideOffset * (1 - END_SCALE);
            float offsetScale = 1 - diffScaledOffset;

            layoutMain.setScaleX(offsetScale);
            layoutMain.setScaleY(offsetScale);

            float xOffset = drawerView.getWidth() * slideOffset;
            float xOffsetDiff = drawerView.getWidth() * diffScaledOffset / 1.5f;
            float xTranslation = xOffset - xOffsetDiff;
            layoutMain.setTranslationX(xTranslation);
        }
    });
}

    @Override
    public void onBackPressed() {
        if (activityMain.isDrawerOpen(GravityCompat.START)) {
            activityMain.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    
    private void openUrl() {
        String githubUrl = "https://github.com/Zyron-Official/Asset-Studio";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl));
        startActivity(intent);
    }

    private void shareApp() {
        String appName = getString(R.string.app_name);
        String appLink = "https://github.com/Zyron-Official/Asset-Studio";
        String appDescription = getString(R.string.app_name);
        String shareInfo = appName + " " + appLink + " " + appDescription;

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareInfo);

        int appIconResource = getApplicationInfo().icon;

        Intent chooser = Intent.createChooser(shareIntent, shareInfo);
        PackageManager packageManager = getPackageManager();
        if (chooser.resolveActivity(packageManager) != null) {
            
        startActivity(chooser);
        }
    }
}
