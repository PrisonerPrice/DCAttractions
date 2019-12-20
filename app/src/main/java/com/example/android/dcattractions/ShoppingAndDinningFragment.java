package com.example.android.dcattractions;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingAndDinningFragment extends Fragment {


    public ShoppingAndDinningFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getResources().getString(R.string.chinatown),
                getResources().getString(R.string.location_chinatown),
                R.drawable.shopping_chinatown,
                38.899755,-77.021841));
        places.add(new Place(getResources().getString(R.string.georgetown),
                getResources().getString(R.string.location_georgetown),
                R.drawable.shopping_georgetown,38.905234,-77.062820));

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
