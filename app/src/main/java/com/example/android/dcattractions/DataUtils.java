package com.example.android.dcattractions;

import android.provider.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class DataUtils extends Fragment {

    public static final ArrayList<Place> places = new ArrayList<>();

    public DataUtils(){
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

    }

    public static ArrayList<Place> getMuseums(){
        return places;
    }
}
