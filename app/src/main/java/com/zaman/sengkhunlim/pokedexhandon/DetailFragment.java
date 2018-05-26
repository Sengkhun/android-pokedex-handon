package com.zaman.sengkhunlim.pokedexhandon;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private String name;
    private int id, descriptionId;
    private ImageView image;
    private TextView description;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        name = getArguments().getString("name");
        id = getArguments().getInt("id");
        descriptionId = getArguments().getInt("descriptionId");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        image = getActivity().findViewById(R.id.pokedex_image);
        description = getActivity().findViewById(R.id.pokedex_description);

        image.setImageResource( id );

        InputStream source = getResources().openRawResource(descriptionId);
        Scanner scan = new Scanner(source);

        description.setText( scan.nextLine() );

    }
}
