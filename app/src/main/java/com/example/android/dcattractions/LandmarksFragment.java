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
public class LandmarksFragment extends Fragment implements PlaceRecyclerAdapter.MyClickListener {

    private static PlaceRecyclerAdapter placeRecyclerAdapter;
    private static RecyclerView recyclerView;
    private Context context;
    private static final ArrayList<Place> places = new ArrayList<Place>();


    public LandmarksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();

        places.clear();

        View rootView = inflater.inflate(R.layout.recyclerview, container, false);

        places.add(new Place(getResources().getString(R.string.white_house),
                getResources().getString(R.string.location_white_house),
                38.897510,-77.036458,
                "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Landmarks/landmarks_white_house.png?raw=true"));
        places.add(new Place(getResources().getString(R.string.lincoln_memorial),
                getResources().getString(R.string.location_lincoln_memorial),
                38.889294,-77.049702,
                "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Landmarks/landmarks_lincoln_memorial.png?raw=true"));
        places.add(new Place(getResources().getString(R.string.washington_monument),
                getResources().getString(R.string.location_washington_monument),
                38.889509,-77.035360,
                "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Landmarks/landmarks_washington_monument.png?raw=true"));
        places.add(new Place(getResources().getString(R.string.united_states_capitol),
                getResources().getString(R.string.location_capitol),
                38.889823,-77.010037,
                "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Landmarks/landmarks_united_capitol.png?raw=true"));
        places.add(new Place(getResources().getString(R.string.thomas_jefferson_memorial),
                getResources().getString(R.string.location_thomas_jefferson_memorial),
                38.881872,-77.036556,
                "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Landmarks/landmarks_thomas_jefferson_memorial.png?raw=true"));

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
