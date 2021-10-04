package com.penguinstech.fooddeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SearchFragment searchFragment = new SearchFragment();
        HomeFragment homeFragment = new HomeFragment();
        DeliveryFragment deliveryFragment = new DeliveryFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        FavouriteFragment favouriteFragment = new FavouriteFragment();

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setSelectedItemId(R.id.home_menu);
        setFragment(homeFragment);
        bottomNav.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.search_menu:
                    setFragment(searchFragment);
                    return true;

                case R.id.deliveries_menu:
                    setFragment(deliveryFragment);
                    return true;

                case R.id.home_menu:
                    setFragment(homeFragment);
                    return true;
                case R.id.favorites_menu:
                    setFragment(favouriteFragment);
                    return true;
                case R.id.profile_menu:
                    setFragment(profileFragment);
                    return true;
            }
            return false;
        });
    }

    private void setFragment (Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, fragment).commit();
    }
}