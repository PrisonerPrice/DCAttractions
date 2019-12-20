package com.example.android.dcattractions;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MuseumsFragment extends Fragment {


    public MuseumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getResources().getString(R.string.smithsonian_national_air_and_space_museum),
                getResources().getString(R.string.location_smithsonian_national_air_and_space_museum),
                R.drawable.museums_smithsonian_national_air_and_space_museum,
                38.887823,-77.019881));
        places.add(new Place(getResources().getString(R.string.smithsonian_national_museum_of_natural_history),
                getResources().getString(R.string.location_smithsonian_national_museum_of_natural_history),
                R.drawable.musuems_smithsonian_national_museum_of_natural_history,
                38.891714,-77.026233));
        places.add(new Place(getResources().getString(R.string.national_museum_of_african_american_history_and_culture),
                getResources().getString(R.string.location_national_museum_of_african_american_history_and_culture),
                R.drawable.museums_national_museum_of_african_american_history_and_culture,
                38.890922,-77.032871));
        places.add(new Place(getResources().getString(R.string.national_gallery_of_art),
                getResources().getString(R.string.location_national_gallery_of_art),
                R.drawable.museums_national_gallery_or_art,
                38.890960,-77.032839));
        places.add(new Place(getResources().getString(R.string.smithsonian_american_art_museum),
                getResources().getString(R.string.location_smithsonian_american_art_museum),
                R.drawable.museums_smithsonian_american_art_museum,38.897393,-77.022946));

        // Set list color
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.colorPrimary);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Place place = places.get(position);
                String geoInformation = "geo:"+ place.getGeoX() + "," + place.getGeoY() + "?q=" + place.getPlaceName();
                Uri mUri = Uri.parse(geoInformation);
                Intent mIntent = new Intent(Intent.ACTION_VIEW,mUri);
                startActivity(mIntent);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

}