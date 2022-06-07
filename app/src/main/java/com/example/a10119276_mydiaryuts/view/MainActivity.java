package com.example.a10119276_mydiaryuts.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.a10119276_mydiaryuts.view.fragment.Fragment0;
import com.example.a10119276_mydiaryuts.view.fragment.Profil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.a10119276_mydiaryuts.R;
import com.example.a10119276_mydiaryuts.view.fragment.DiaryFragment;

/**
 *  NIM   : 10119276
 *  Nama  : Nasthasa Wulan Ghani Sopian
 *  Kelas : IF-7
 */

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView botNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        //menampilkan halaman yang pertama muncul
        getFragmentPage(new Fragment0());

        //insialisasi bottom nav
        botNav = findViewById(R.id.botNav);
        botNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case
                            R.id.info:
                        fragment = new Fragment0();
                        break;
                    case
                            R.id.diary:
                        fragment = new DiaryFragment();
                        break;
                    case
                            R.id.profil:
                        fragment = new Profil();
                        break;
                }
                return getFragmentPage(fragment);
            }
        });
    }

    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.rv_diary, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}

