package com.example.android.dcattractions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlaceRecyclerAdapter extends RecyclerView.Adapter<PlaceRecyclerAdapter.PlaceViewHolder> {

    private ArrayList<Place> data;

    private final MyClickListener myClickListener;

    public PlaceRecyclerAdapter(ArrayList<Place> data, MyClickListener myClickListener) {
        this.data = data;
        this.myClickListener = myClickListener;
    }

    @Override
    public PlaceViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutId, parent, shouldAttachToParentImmediately);
        PlaceViewHolder placeViewHolder = new PlaceViewHolder(view);

        return placeViewHolder;
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        if(data != null && data.size() != 0){
            Place place = data.get(position);
            holder.placeImageView.setImageResource(place.getPlaceImage());
            holder.placeLocationTextView.setText(place.getPlaceLocation());
            holder.placeNameTextView.setText(place.getPlaceName());
        } else{
            // need to be implemented
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView placeNameTextView;
        TextView placeLocationTextView;
        ImageView placeImageView;

        public PlaceViewHolder(View itemView) {
            super(itemView);
            placeNameTextView = (TextView) itemView.findViewById(R.id.place_name_text_view);
            placeLocationTextView = (TextView) itemView.findViewById(R.id.place_location_text_view);
            placeImageView = (ImageView) itemView.findViewById(R.id.place_image_view);
        }

        @Override
        public void onClick(View view) {
            myClickListener.onItemClick(getAdapterPosition());
        }
    }

    interface MyClickListener{
        void onItemClick(int position);
    }
}
