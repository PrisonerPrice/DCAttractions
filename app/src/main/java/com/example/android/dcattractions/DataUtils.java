package com.example.android.dcattractions;

import android.content.Context;
import android.content.res.Resources;
import java.util.ArrayList;

public class DataUtils {

    private static Context context;
    private static Resources resources;

    private final static ArrayList<Place> landmarks = new ArrayList<>();
    private final static ArrayList<Place> museums = new ArrayList<>();
    private final static ArrayList<Place> greens = new ArrayList<>();
    private final static ArrayList<Place> shoppingAndDining = new ArrayList<>();

    public DataUtils(Context context){
        this.context = context;
        resources = context.getResources();
    }

    public static ArrayList<Place> getLandmarks(){
        if (landmarks.size() > 0){

        } else {
            landmarks.add(new Place(resources.getString(R.string.white_house),
                    resources.getString(R.string.location_white_house),
                    38.897510,-77.036458,
                    "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Landmarks/landmarks_white_house.png?raw=true"));
            landmarks.add(new Place(resources.getString(R.string.lincoln_memorial),
                    resources.getString(R.string.location_lincoln_memorial),
                    38.889294,-77.049702,
                    "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Landmarks/landmarks_lincoln_memorial.png?raw=true"));
            landmarks.add(new Place(resources.getString(R.string.washington_monument),
                    resources.getString(R.string.location_washington_monument),
                    38.889509,-77.035360,
                    "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Landmarks/landmarks_washington_monument.png?raw=true"));
            landmarks.add(new Place(resources.getString(R.string.united_states_capitol),
                    resources.getString(R.string.location_capitol),
                    38.889823,-77.010037,
                    "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Landmarks/landmarks_united_capitol.png?raw=true"));
            landmarks.add(new Place(resources.getString(R.string.thomas_jefferson_memorial),
                    resources.getString(R.string.location_thomas_jefferson_memorial),
                    38.881872,-77.036556,
                    "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Landmarks/landmarks_thomas_jefferson_memorial.png?raw=true"));
        }
        return landmarks;
    }

    public static ArrayList<Place> getMuseums(){
        if (museums.size() > 0){

        } else {
            museums.add(new Place(resources.getString(R.string.smithsonian_national_air_and_space_museum),
                    resources.getString(R.string.location_smithsonian_national_air_and_space_museum),
                    38.887823,-77.019881,
                    "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Museums/museums_smithsonian_national_air_and_space_museum.png?raw=true"));
            museums.add(new Place(resources.getString(R.string.smithsonian_national_museum_of_natural_history),
                    resources.getString(R.string.location_smithsonian_national_museum_of_natural_history),
                    38.891714,-77.026233,
                    "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Museums/musuems_smithsonian_national_museum_of_natural_history.png?raw=true"));
            museums.add(new Place(resources.getString(R.string.national_museum_of_african_american_history_and_culture),
                    resources.getString(R.string.location_national_museum_of_african_american_history_and_culture),
                    38.890922,-77.032871,
                    "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Museums/museums_national_museum_of_african_american_history_and_culture.png?raw=true"));
            museums.add(new Place(resources.getString(R.string.national_gallery_of_art),
                    resources.getString(R.string.location_national_gallery_of_art),
                    38.890960,-77.032839,
                    "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Museums/museums_national_gallery_or_art.png?raw=true"));
            museums.add(new Place(resources.getString(R.string.smithsonian_american_art_museum),
                    resources.getString(R.string.location_smithsonian_american_art_museum),
                    38.897393,-77.022946,
                    "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Museums/museums_smithsonian_american_art_museum.png?raw=true"));
        }
        return museums;
    }

    public static ArrayList<Place> getGreens(){
        if (greens.size() > 0){

        } else{
            greens.add(new Place(resources.getString(R.string.national_mall),
                    resources.getString(R.string.washington_dc),
                    38.889663,-77.022982,
                    "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Greens/greens_national_mall.png?raw=true"));
            greens.add(new Place(resources.getString(R.string.tidal_basin),
                    resources.getString(R.string.washington_dc),
                    38.886449,-77.042160,
                    "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Greens/greens_tidal_basin.png?raw=true"));
        }
        return greens;
    }

    public static ArrayList<Place> getShoppingAndDining(){
        if (shoppingAndDining.size() > 0){

        } else {
            shoppingAndDining.add(new Place(resources.getString(R.string.chinatown),
                    resources.getString(R.string.location_chinatown),
                    38.899755,-77.021841,
                    "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Shopping/shopping_chinatown.png?raw=true"));
            shoppingAndDining.add(new Place(resources.getString(R.string.georgetown),
                    resources.getString(R.string.location_georgetown),
                    38.905234,-77.062820,
                    "https://github.com/PrisonerPrice/DCAttractions/blob/master/Images/Shopping/shopping_georgetown.png?raw=true"));
        }
        return shoppingAndDining;
    }
}
