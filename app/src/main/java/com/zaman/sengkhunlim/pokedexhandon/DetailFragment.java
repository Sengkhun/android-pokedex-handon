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

    private int imageId, descriptionId;
    private String name;

    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getArgument();
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState == null) refresh();

    }

    public void getArgument() {

        name = getArguments().getString("name");
        imageId = getArguments().getInt("imageId");
        descriptionId = getArguments().getInt("descriptionId");

    }

    public void setContentToView() {

        TextView nameText = getActivity().findViewById(R.id.pokedex_name);
        ImageView image = getActivity().findViewById(R.id.pokedex_image);
        TextView descriptionText = getActivity().findViewById(R.id.pokedex_description);

        if (imageId != 0) { // Have arguments

            String description = "";
            nameText.setText(name);
            image.setImageResource(imageId);

            InputStream source = getResources().openRawResource(descriptionId);
            Scanner scan = new Scanner(source);

            while (scan.hasNext()) {
                description += scan.nextLine();
            }

            descriptionText.setText(description);

        }

    }

    public void refresh() {

        getArgument();
        setContentToView();

    }

}
