package com.example.marlowex.hopitalink;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //use custom toolbar
        Toolbar mToolBar = (Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolBar);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        //set custom view and assign to actionbar
        View mCustomView = mInflater.inflate(R.layout.custom_action_bar_layout, null);
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
        TextView titleText = (TextView)findViewById(R.id.title_text);
        titleText.setText("Profile");

        //initialize drawerlayout
        initDrawerLayout();

        //initialize profile
        initProfile();
    }

    public void initProfile(){
        LinearLayout mainProfile = (LinearLayout)findViewById(R.id.main_profile_layout);
        TextView name = Utility.createBasicTextView(this, mainProfile, "blah", 20);
        LinearLayout subProfile = (LinearLayout)findViewById(R.id.sub_profile_layout);
        TextView desc = Utility.createBasicTextView(this, mainProfile, "another blah", 20);
    }

    //-----------------------------Left-side Navigation bar---------------------
    public void profile(View view){
        if(this.getClass().isAssignableFrom(ProfileActivity.class)){
            toggleLeftSliding();
        }else{
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void patientList(View view){
        if(this.getClass().isAssignableFrom(PatientListActivity.class)){
            toggleLeftSliding();
        }else{
            Intent intent = new Intent(this, PatientListActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void appointmments(View view){
        if(this.getClass().isAssignableFrom(AppointmentsActivity.class)){
            toggleLeftSliding();
        }else{
            Intent intent = new Intent(this, AppointmentsActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void logOut(View view){
        if(this.getClass().isAssignableFrom(LoginActivity.class)){
            toggleLeftSliding();
        }else{
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void setting(View view){
        if(this.getClass().isAssignableFrom(SettingActivity.class)){
            toggleLeftSliding();
        }else{
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
            finish();
        }
    }

    //-----------------------------------DrawerLayout-------------------------------------
    private void initDrawerLayout(){
        drawerLayout = (DrawerLayout)findViewById(R.id.layout_drawer);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        Toolbar mToolBar = (Toolbar)findViewById(R.id.main_toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, mToolBar, R.string.app_name, R.string.app_name){
            public void onDrawerClosed(View drawerView){
                super.onDrawerClosed(drawerView);
            }

            public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(toggle);
    }

    private void toggleLeftSliding(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    public void menuSliding(View view){
        toggleLeftSliding();
    }
}
