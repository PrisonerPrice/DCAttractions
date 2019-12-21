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
public class ShoppingAndDinningFragment extends Fragment implements PlaceRecyclerAdapter.MyClickListener {

    private static PlaceRecyclerAdapter placeRecyclerAdapter;
    private static RecyclerView recyclerView;
    private Context context;
    private static final ArrayList<Place> places = new ArrayList<Place>();

    public ShoppingAndDinningFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();

        places.clear();

        View rootView = inflater.inflate(R.layout.recyclerview, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getResources().getString(R.string.chinatown),
                getResources().getString(R.string.location_chinatown),
                R.drawable.shopping_chinatown,
                38.899755,-77.021841));
        places.add(new Place(getResources().getString(R.string.georgetown),
                getResources().getString(R.string.location_georgetown),
                R.drawable.shopping_georgetown,38.905234,-77.062820));

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
