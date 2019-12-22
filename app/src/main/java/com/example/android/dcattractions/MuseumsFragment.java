package com.example.android.dcattractions;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MuseumsFragment extends Fragment implements PlaceRecyclerAdapter.MyClickListener {

    private static PlaceRecyclerAdapter placeRecyclerAdapter;
    private static RecyclerView recyclerView;
    private Context context;
    private static final ArrayList<Place> places = new ArrayList<Place>();

    public MuseumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();

        places.clear();

        View rootView = inflater.inflate(R.layout.recyclerview, container, false);

        places.add(new Place(getResources().getString(R.string.smithsonian_national_air_and_space_museum),
                getResources().getString(R.string.location_smithsonian_national_air_and_space_museum),
                38.887823,-77.019881,
                "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Museums/museums_smithsonian_national_air_and_space_museum.png?raw=true"));
        places.add(new Place(getResources().getString(R.string.smithsonian_national_museum_of_natural_history),
                getResources().getString(R.string.location_smithsonian_national_museum_of_natural_history),
                38.891714,-77.026233,
                "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Museums/musuems_smithsonian_national_museum_of_natural_history.png?raw=true"));
        places.add(new Place(getResources().getString(R.string.national_museum_of_african_american_history_and_culture),
                getResources().getString(R.string.location_national_museum_of_african_american_history_and_culture),
                38.890922,-77.032871,
                "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Museums/museums_national_museum_of_african_american_history_and_culture.png?raw=true"));
        places.add(new Place(getResources().getString(R.string.national_gallery_of_art),
                getResources().getString(R.string.location_national_gallery_of_art),
                38.890960,-77.032839,
                "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Museums/museums_national_gallery_or_art.png?raw=true"));
        places.add(new Place(getResources().getString(R.string.smithsonian_american_art_museum),
                getResources().getString(R.string.location_smithsonian_american_art_museum),
                38.897393,-77.022946,
                "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Museums/museums_smithsonian_american_art_museum.png?raw=true"));

        placeRecyclerAdapter = new PlaceRecyclerAdapter(places, this, R.color.colorPrimary, getContext());
        recyclerView = rootView.findViewById(R.id.recycler_view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 1);

        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(placeRecyclerAdapter);
        return rootView;
    }

    @Override
    public void onItemClick(int position) {
        Place place = places.get(position);
        String geoInformation = "geo:"+ place.getGeoX() + "," + place.getGeoY() + "?q=" + place.getPlaceName();
        Uri mUri = Uri.parse(geoInformation);
        Intent mIntent = new Intent(Intent.ACTION_VIEW,mUri);
        startActivity(mIntent);
    }
}
