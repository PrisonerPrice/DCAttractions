package com.example.android.dcattractions;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GreensFragment extends Fragment {


    public GreensFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getResources().getString(R.string.national_mall),
                getResources().getString(R.string.washington_dc),
                R.drawable.greens_national_mall,
                38.889663,-77.022982));
        places.add(new Place(getResources().getString(R.string.tidal_basin),
                getResources().getString(R.string.washington_dc),
                R.drawable.greens_tidal_basin,
                38.886449,-77.042160));

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
