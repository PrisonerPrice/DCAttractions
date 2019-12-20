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
public class LandmarksFragment extends Fragment {


    public LandmarksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getResources().getString(R.string.white_house),
                getResources().getString(R.string.location_white_house),
                R.drawable.landmarks_white_house,
                38.897510,-77.036458));
        places.add(new Place(getResources().getString(R.string.lincoln_memorial),
                getResources().getString(R.string.location_lincoln_memorial),
                R.drawable.landmarks_lincoln_memorial,
                38.889294,-77.049702));
        places.add(new Place(getResources().getString(R.string.washington_monument),
                getResources().getString(R.string.location_washington_monument),
                R.drawable.landmarks_washington_monument,
                38.889509,-77.035360));
        places.add(new Place(getResources().getString(R.string.united_states_capitol),
                getResources().getString(R.string.location_capitol),
                R.drawable.landmarks_united_capitol,
                38.889823,-77.010037));
        places.add(new Place(getResources().getString(R.string.thomas_jefferson_memorial),
                getResources().getString(R.string.location_thomas_jefferson_memorial),
                R.drawable.landmarks_thomas_jefferson_memorial,
                38.881872,-77.036556));

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
