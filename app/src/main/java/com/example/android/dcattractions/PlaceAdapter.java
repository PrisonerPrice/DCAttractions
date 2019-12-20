package com.example.android.dcattractions;

import android.content.Context;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    private int backgroundColorResID;

    public PlaceAdapter(Context context, ArrayList<Place> places, int colorResID){
        super(context,0, places);
        backgroundColorResID = colorResID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Place currentPlace = getItem(position);

        TextView placeNameTextView = (TextView) listItemView.findViewById(R.id.place_name_text_view);
        placeNameTextView.setText(currentPlace.getPlaceName());

        TextView placeLocationTextView = (TextView) listItemView.findViewById(R.id.place_location_text_view);
        placeLocationTextView.setText(currentPlace.getPlaceLocation());

        ImageView placeImageView = (ImageView) listItemView.findViewById(R.id.place_image_view);
        placeImageView.setImageResource(currentPlace.getPlaceImage());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),backgroundColorResID);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
