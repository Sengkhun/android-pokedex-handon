package com.zaman.sengkhunlim.pokedexhandon;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        setFragment(homeFragment);

    }

    public void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment).commit();

    }

    public void pokedexClick(View view) {

        String name = view.getTag().toString();
        int id = view.getResources().getIdentifier(name, "drawable", getPackageName());
        int descriptionId = view.getResources().getIdentifier(name, "raw", getPackageName());

        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("id", id);
        intent.putExtra("descriptionId", descriptionId);
        startActivity(intent);

    }

}
