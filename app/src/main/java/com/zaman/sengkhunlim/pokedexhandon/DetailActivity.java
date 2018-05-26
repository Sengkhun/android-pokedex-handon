package com.zaman.sengkhunlim.pokedexhandon;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    private DetailFragment detailFragment;
    private String pokedexName;
    private int pokedexId, pokedexDescriptionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        pokedexName = getIntent().getStringExtra("name");
        pokedexId = getIntent().getIntExtra( "id", 0);
        pokedexDescriptionId = getIntent().getIntExtra( "descriptionId", 0);

        setTitle(pokedexName + " Detail");

        Bundle b = new Bundle();
        b.putString( "name", pokedexName );
        b.putInt( "id", pokedexId );
        b.putInt( "descriptionId", pokedexDescriptionId );

        detailFragment = new DetailFragment();
        detailFragment.setArguments( b );

        // Set Detail Fragment to Activity
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.detail_frame, detailFragment).commit();

    }

}
