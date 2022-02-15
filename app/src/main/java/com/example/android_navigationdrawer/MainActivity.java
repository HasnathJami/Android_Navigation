package com.example.android_navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ClipData;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawerLayoutId);
        navigationView=findViewById(R.id.navViewId);
        toolbar=findViewById(R.id.toolBarId);
       setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle); // drawer listens toogle
        toggle.syncState();

        // Default fragment checked and menu checked before starting menu
        getSupportFragmentManager().beginTransaction().replace(R.id.containerId,new HomeFragment()).commit();
        navigationView.setCheckedItem(R.id.home);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            Fragment store;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                   switch(item.getItemId()){

                       case R.id.home:
                           //drawerLayout.closeDrawer(GravityCompat.START);
                          // Toast.makeText(getApplicationContext(), "Home is clicked", Toast.LENGTH_SHORT).show();
                           store= new HomeFragment();

                           break;

                       case R.id.call:
                          // drawerLayout.closeDrawer(GravityCompat.START);
                           //Toast.makeText(getApplicationContext(), "Call is clicked", Toast.LENGTH_SHORT).show();
                           store=new CallFragment();

                           break;


                       case R.id.setting:
                           //drawerLayout.closeDrawer(GravityCompat.START);
                           //Toast.makeText(getApplicationContext(), "Setting is clicked", Toast.LENGTH_SHORT).show();
                           store=new SettingFragment();

                           break;



                   }
                 getSupportFragmentManager().beginTransaction().replace(R.id.containerId,store).commit();
                drawerLayout.closeDrawer(GravityCompat.START);


                return true;
            }
        });

    }
}