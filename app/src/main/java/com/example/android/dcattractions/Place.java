package com.example.android.dcattractions;

public class Place {

    private String mName;

    private String mLocation;

    private int mImageResID;

    // Latitude
    private double mGeoX;

    // Longitude
    private double mGeoY;

    private String imageUrl;

    public Place(String mName, String mLocation, int mImageResID, double mGeoX, double mGeoY, String mImageURL) {
        this.mName = mName;
        this.mLocation = mLocation;
        this.mImageResID = mImageResID;
        this.mGeoX = mGeoX;
        this.mGeoY = mGeoY;
        this.imageUrl = mImageURL;
    }

    public Place(String mName, String mLocation, double mGeoX, double mGeoY, String imageUrl) {
        this.mName = mName;
        this.mLocation = mLocation;
        this.mGeoX = mGeoX;
        this.mGeoY = mGeoY;
        this.imageUrl = imageUrl;
    }

    public String getPlaceName(){return  mName;}

    public String getPlaceLocation(){return mLocation;}

    public int getPlaceImage(){return mImageResID;}

    public String getImageUrl() {
        return imageUrl;
    }

    public double getGeoX(){return mGeoX;}

    public double getGeoY(){return mGeoY;}
}
