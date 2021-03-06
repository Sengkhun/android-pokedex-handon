package com.zaman.sengkhunlim.pokedexhandon;

import android.content.res.Configuration;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    private DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("Pokedex Detail");

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if (savedInstanceState == null) {

            detailFragment = new DetailFragment();
            detailFragment.setArguments( getIntent().getExtras() );

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.detail_frame, detailFragment).commit();

        }

//        Bundle b = new Bundle();
//        b.putString( "name", pokedexName );
//        b.putInt( "imageId", pokedexImageId );
//        b.putInt( "descriptionId", pokedexDescriptionId );
//
//        detailFragment = new DetailFragment();
//        detailFragment.setArguments( b );
//
//        // Set Detail Fragment to Activity
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.detail_frame, detailFragment).commit();

    }

}
