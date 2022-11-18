package com.example.flxvay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.flxvay.UI.FavoriteFragment;
import com.example.flxvay.UI.HomeFragment;
import com.example.flxvay.UI.MyCartFragment;
import com.example.flxvay.UI.MyOrderFragment;
import com.example.flxvay.UI.ProfileFragment;
import com.example.flxvay.UI.SettingsFragment;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DuoDrawerLayout drawerLayout;
    private TextView Home, Profile, My_Cart, Favorite, My_Orders, Language, Settings;
    private static final int HOME_FRAGMENT = 0;
    private static final int PROFILE_FRAGMENT = 1;
    private static final int MY_CART_FRAGMENT = 2;
    private static final int FAVORITE_FRAGMENT = 3;
    private static final int MY_ORDER_FRAGMENT = 4;
    private static final int LANGUAGE_FRAGMENT = 5;
    private static final int SETTINGS_FRAGMENT = 6;
    public static Boolean ShowCart = false;

    public  int currentFragment = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();


    }

    private void init() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        drawerLayout = (DuoDrawerLayout) findViewById(R.id.drawer);


        View contentView = drawerLayout.getContentView();
        View menuView = drawerLayout.getMenuView();

        if (ShowCart){

            drawerLayout.setDrawerLockMode(DuoDrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            gotoFragment("MyCart", new MyCartFragment(), -2);

       }else {

            DuoDrawerToggle drawerToggle = new DuoDrawerToggle(this, drawerLayout, toolbar,
                    R.string.navigation_drawer_open,
                    R.string.navigation_drawer_close);

            drawerLayout.setDrawerListener(drawerToggle);
            drawerToggle.syncState();

           Home = menuView.findViewById(R.id.Home);
           Profile = menuView.findViewById(R.id.Profile);
           My_Cart = menuView.findViewById(R.id.My_Cart);
           Favorite = menuView.findViewById(R.id.Favorite);
           My_Orders = menuView.findViewById(R.id.My_Orders);
           Language = menuView.findViewById(R.id.Language);
           Settings = menuView.findViewById(R.id.Settings);

           Home.setOnClickListener(this);
           Profile.setOnClickListener(this);
           My_Cart.setOnClickListener(this);
           Favorite.setOnClickListener(this);
           My_Orders.setOnClickListener(this);
           Language.setOnClickListener(this);
           Settings.setOnClickListener(this);

           HomeFragmentCalling();
       }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Home:
                invalidateOptionsMenu();
                HomeFragmentCalling();
                break;

            case R.id.Profile:

                gotoFragment("Profile", new ProfileFragment(), PROFILE_FRAGMENT);

                Home.setTextColor(getResources().getColor(R.color.black_browen));
                Profile.setTextColor(getResources().getColor(R.color.blue_default_color));
                My_Cart.setTextColor(getResources().getColor(R.color.black_browen));
                Favorite.setTextColor(getResources().getColor(R.color.black_browen));
                My_Orders.setTextColor(getResources().getColor(R.color.black_browen));
                Language.setTextColor(getResources().getColor(R.color.black_browen));
                Settings.setTextColor(getResources().getColor(R.color.black_browen));

                Home.setTypeface(null, Typeface.NORMAL);
                Profile.setTypeface(null, Typeface.BOLD);
                My_Cart.setTypeface(null, Typeface.NORMAL);
                Favorite.setTypeface(null, Typeface.NORMAL);
                My_Orders.setTypeface(null, Typeface.NORMAL);
                Language.setTypeface(null, Typeface.NORMAL);
                Settings.setTypeface(null, Typeface.NORMAL);


                break;

            case R.id.My_Cart:
                //  replace(new SettingFragment(),"Setting");
                gotoFragment("MyCart", new MyCartFragment(), MY_CART_FRAGMENT);
                break;

            case R.id.Favorite:

                gotoFragment("Favorite", new FavoriteFragment(), FAVORITE_FRAGMENT);


                Home.setTextColor(getResources().getColor(R.color.black_browen));
                Profile.setTextColor(getResources().getColor(R.color.black_browen));
                My_Cart.setTextColor(getResources().getColor(R.color.black_browen));
                Favorite.setTextColor(getResources().getColor(R.color.blue_default_color));
                My_Orders.setTextColor(getResources().getColor(R.color.black_browen));
                Language.setTextColor(getResources().getColor(R.color.black_browen));
                Settings.setTextColor(getResources().getColor(R.color.black_browen));

                Home.setTypeface(null, Typeface.NORMAL);
                Profile.setTypeface(null, Typeface.NORMAL);
                My_Cart.setTypeface(null, Typeface.NORMAL);
                Favorite.setTypeface(null, Typeface.BOLD);
                My_Orders.setTypeface(null, Typeface.NORMAL);
                Language.setTypeface(null, Typeface.NORMAL);
                Settings.setTypeface(null, Typeface.NORMAL);


                break;

            case R.id.My_Orders:

                gotoFragment("MyOrder", new MyOrderFragment(), MY_ORDER_FRAGMENT);

                Home.setTextColor(getResources().getColor(R.color.black_browen));
                Profile.setTextColor(getResources().getColor(R.color.black_browen));
                My_Cart.setTextColor(getResources().getColor(R.color.black_browen));
                Favorite.setTextColor(getResources().getColor(R.color.black_browen));
                My_Orders.setTextColor(getResources().getColor(R.color.blue_default_color));
                Language.setTextColor(getResources().getColor(R.color.black_browen));
                Settings.setTextColor(getResources().getColor(R.color.black_browen));

                Home.setTypeface(null, Typeface.NORMAL);
                Profile.setTypeface(null, Typeface.NORMAL);
                My_Cart.setTypeface(null, Typeface.NORMAL);
                Favorite.setTypeface(null, Typeface.NORMAL);
                My_Orders.setTypeface(null, Typeface.BOLD);
                Language.setTypeface(null, Typeface.NORMAL);
                Settings.setTypeface(null, Typeface.NORMAL);


                break;

            case R.id.Language:
                // Toast.makeText(this, "Logout...", Toast.LENGTH_SHORT).show();

                Home.setTextColor(getResources().getColor(R.color.black_browen));
                Profile.setTextColor(getResources().getColor(R.color.black_browen));
                My_Cart.setTextColor(getResources().getColor(R.color.black_browen));
                Favorite.setTextColor(getResources().getColor(R.color.black_browen));
                My_Orders.setTextColor(getResources().getColor(R.color.black_browen));
                Language.setTextColor(getResources().getColor(R.color.blue_default_color));
                Settings.setTextColor(getResources().getColor(R.color.black_browen));

                Home.setTypeface(null, Typeface.NORMAL);
                Profile.setTypeface(null, Typeface.NORMAL);
                My_Cart.setTypeface(null, Typeface.NORMAL);
                Favorite.setTypeface(null, Typeface.NORMAL);
                My_Orders.setTypeface(null, Typeface.NORMAL);
                Language.setTypeface(null, Typeface.BOLD);
                Settings.setTypeface(null, Typeface.NORMAL);


                break;

            case R.id.Settings:
                gotoFragment("Settings", new SettingsFragment(), SETTINGS_FRAGMENT);
                // Toast.makeText(this, "Logout...", Toast.LENGTH_SHORT).show();

                Home.setTextColor(getResources().getColor(R.color.black_browen));
                Profile.setTextColor(getResources().getColor(R.color.black_browen));
                My_Cart.setTextColor(getResources().getColor(R.color.black_browen));
                Favorite.setTextColor(getResources().getColor(R.color.black_browen));
                My_Orders.setTextColor(getResources().getColor(R.color.black_browen));
                Language.setTextColor(getResources().getColor(R.color.black_browen));
                Settings.setTextColor(getResources().getColor(R.color.blue_default_color));

                Home.setTypeface(null, Typeface.NORMAL);
                Profile.setTypeface(null, Typeface.NORMAL);
                My_Cart.setTypeface(null, Typeface.NORMAL);
                Favorite.setTypeface(null, Typeface.NORMAL);
                My_Orders.setTypeface(null, Typeface.NORMAL);
                Language.setTypeface(null, Typeface.NORMAL);
                Settings.setTypeface(null, Typeface.BOLD);


                break;

        }
        drawerLayout.closeDrawer();
    }

    public void onBackPressed() {
        if (currentFragment == HOME_FRAGMENT) {
            currentFragment = -1;
            super.onBackPressed();
        }else {
            if (ShowCart){
                ShowCart = false;
                finish();

            }else {
                invalidateOptionsMenu();
                HomeFragmentCalling();
            }
        }
    }

    private void HomeFragmentCalling() {

        gotoFragment("Home", new HomeFragment(), HOME_FRAGMENT);

        Home.setTextColor(getResources().getColor(R.color.blue_default_color));
        Profile.setTextColor(getResources().getColor(R.color.black_browen));
        My_Cart.setTextColor(getResources().getColor(R.color.black_browen));
        Favorite.setTextColor(getResources().getColor(R.color.black_browen));
        My_Orders.setTextColor(getResources().getColor(R.color.black_browen));
        Language.setTextColor(getResources().getColor(R.color.black_browen));
        Settings.setTextColor(getResources().getColor(R.color.black_browen));

        Home.setTypeface(null, Typeface.BOLD);
        Profile.setTypeface(null, Typeface.NORMAL);
        My_Cart.setTypeface(null, Typeface.NORMAL);
        Favorite.setTypeface(null, Typeface.NORMAL);
        My_Orders.setTypeface(null, Typeface.NORMAL);
        Language.setTypeface(null, Typeface.NORMAL);
        Settings.setTypeface(null, Typeface.NORMAL);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        if (currentFragment == HOME_FRAGMENT) {
            getMenuInflater().inflate(R.menu.main, menu);

            for (int i = 0; i < menu.size(); i++) {
                Drawable drawable = menu.getItem(i).getIcon();
                if (drawable != null) {
                    drawable.mutate();
                    drawable.setColorFilter(getResources().getColor(R.color.black_browen), PorterDuff.Mode.SRC_ATOP);
                }
            }
        }else {
            getMenuInflater().inflate(R.menu.notification_menu, menu);

            for (int i = 0; i < menu.size(); i++) {
                Drawable drawable = menu.getItem(i).getIcon();
                if (drawable != null) {
                    drawable.mutate();
                    drawable.setColorFilter(getResources().getColor(R.color.black_browen), PorterDuff.Mode.SRC_ATOP);
                }
            }
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (currentFragment == HOME_FRAGMENT) {
            if (id == R.id.main_notification) {

                return true;
            } else if (id == R.id.main_Cart) {

//                Intent RegisterIntent = new Intent(MainActivity.this,RegisterActivity.class);
//                startActivity(RegisterIntent);

                drawerLayout.setDrawerLockMode(DuoDrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                gotoFragment("MyCart", new MyCartFragment(), MY_CART_FRAGMENT);
                return true;
            }else if (id == android.R.id.home){
                if (ShowCart){
                    ShowCart = false;
                    finish();
                    return true;
                }
            }
        }else {
            if (id == R.id.Notification_menu) {

                Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show();
                return true;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    private void gotoFragment(String title, Fragment fragment, int FragmentNumber) {
        getSupportActionBar().setTitle(title);
        setFragment(fragment, FragmentNumber);
        invalidateOptionsMenu();

        if (FragmentNumber == MY_CART_FRAGMENT) {
            Home.setTextColor(getResources().getColor(R.color.black_browen));
            Profile.setTextColor(getResources().getColor(R.color.black_browen));
            My_Cart.setTextColor(getResources().getColor(R.color.blue_default_color));
            Favorite.setTextColor(getResources().getColor(R.color.black_browen));
            My_Orders.setTextColor(getResources().getColor(R.color.black_browen));
            Language.setTextColor(getResources().getColor(R.color.black_browen));
            Settings.setTextColor(getResources().getColor(R.color.black_browen));

            Home.setTypeface(null, Typeface.NORMAL);
            Profile.setTypeface(null, Typeface.NORMAL);
            My_Cart.setTypeface(null, Typeface.BOLD);
            Favorite.setTypeface(null, Typeface.NORMAL);
            My_Orders.setTypeface(null, Typeface.NORMAL);
            Language.setTypeface(null, Typeface.NORMAL);
            Settings.setTypeface(null, Typeface.NORMAL);
        }
    }

    private void setFragment(Fragment fragment, int FragmentNumber) {
        if (currentFragment != FragmentNumber) {
            currentFragment = FragmentNumber;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame, fragment);
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            transaction.commit();
        }
    }
}