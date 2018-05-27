package com.zaman.sengkhunlim.pokedexhandon;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private DetailFragment detailFragment;
    private Bundle b;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        detailFragment = new DetailFragment();

        b = new Bundle();

        setFragment(R.id.main_frame, homeFragment);

        // if landscape mode
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            b.putInt("imageId", 0);
            b.putInt("descriptionId", 0);
            detailFragment.setArguments(b);

            setFragment(R.id.detail_frame, detailFragment);

        }

    }

    public void setFragment(int frameId, Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameId, fragment).commit();

    }

    public void pokedexClick(View view) {

        String name = view.getTag().toString();
        int imageId = view.getResources().getIdentifier(name, "drawable", getPackageName());
        int descriptionId = view.getResources().getIdentifier(name, "raw", getPackageName());

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            b.putString("name", name);
            b.putInt("imageId", imageId);
            b.putInt("descriptionId", descriptionId);

            detailFragment.setArguments(b);
            detailFragment.refresh();

        } else {

            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("imageId", imageId);
            intent.putExtra("descriptionId", descriptionId);
            startActivity(intent);

        }

    }

}
