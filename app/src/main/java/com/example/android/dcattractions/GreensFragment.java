package com.example.android.dcattractions;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GreensFragment extends Fragment implements PlaceRecyclerAdapter.MyClickListener {

    private static PlaceRecyclerAdapter placeRecyclerAdapter;
    private static RecyclerView recyclerView;
    private Context context;
    private static final ArrayList<Place> places = new ArrayList<Place>();

    public GreensFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();

        places.clear();

        View rootView = inflater.inflate(R.layout.recyclerview, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getResources().getString(R.string.national_mall),
                getResources().getString(R.string.washington_dc),
                38.889663,-77.022982,
                "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Greens/greens_national_mall.png?raw=true"));
        places.add(new Place(getResources().getString(R.string.tidal_basin),
                getResources().getString(R.string.washington_dc),
                38.886449,-77.042160,
                "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Greens/greens_tidal_basin.png?raw=true"));

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
