package com.miui.foodbuzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.miui.foodbuzz.Fragments.FragmentAccount;
import com.miui.foodbuzz.Fragments.FragmentCart;
import com.miui.foodbuzz.Fragments.FragmentHome;
import com.miui.foodbuzz.Fragments.FragmentSave;

public class MainActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        bottomNavigationView = findViewById(R.id.bottom_nav_menu);
        chipNavigationBar = findViewById(R.id.bottom_nav_menu);
        chipNavigationBar.setItemSelected(R.id.id_home, true);
        replaceFragment(new FragmentHome());
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentHome()).commit();
        bottomMenu();

    }


    private void bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i) {
                    case R.id.id_home:
                        replaceFragment(new FragmentHome());
                        break;
                    case R.id.id_save:
                        replaceFragment(new FragmentSave());
                        break;
                    case R.id.id_cart:
                        replaceFragment(new FragmentCart());
                        break;
                    case R.id.id_account:
                        replaceFragment(new FragmentAccount());
                        break;
                }
            }
        });
    }



    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.id_frameLayout, fragment);
        fragmentTransaction.commit();
    }


}