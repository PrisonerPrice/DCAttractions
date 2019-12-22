package com.example.android.dcattractions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlaceRecyclerAdapter extends RecyclerView.Adapter<PlaceRecyclerAdapter.PlaceViewHolder> {

    private ArrayList<Place> data;

    private final MyClickListener myClickListener;

    private int backgroundColorResID;

    private Context context;



    public PlaceRecyclerAdapter(ArrayList<Place> data, MyClickListener myClickListener, int colorId, Context context) {
        this.data = data;
        this.myClickListener = myClickListener;
        backgroundColorResID = colorId;
        this.context = context;
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
        int color = ContextCompat.getColor(context,backgroundColorResID);
        if(data != null && data.size() != 0){
            Place place = data.get(position);
            holder.placeNameTextView.setText(place.getPlaceName());
            holder.placeLocationTextView.setText(place.getPlaceLocation());
            Picasso.get().
                    load(place.getImageUrl()).
                    placeholder(R.drawable.map).
                    into(holder.placeImageView);
            Picasso.get().setLoggingEnabled(true);
            holder.relativeLayout.setBackgroundColor(color);
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
        RelativeLayout relativeLayout;

        public PlaceViewHolder(View itemView) {
            super(itemView);
            placeNameTextView = (TextView) itemView.findViewById(R.id.place_name_text_view);
            placeLocationTextView = (TextView) itemView.findViewById(R.id.place_location_text_view);
            placeImageView = (ImageView) itemView.findViewById(R.id.place_image_view);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.list_item);
            itemView.setOnClickListener(this);
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
