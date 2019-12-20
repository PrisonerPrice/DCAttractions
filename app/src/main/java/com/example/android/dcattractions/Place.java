package com.example.android.dcattractions;

public class Place {

    private String mName;

    private String mLocation;

    private int mImageResID;

    // Latitude
    private double mGeoX;

    // Longitude
    private double mGeoY;

    public Place(String name, String location, int imageResID, double GeoX, double GeoY){
        mName = name;
        mLocation = location;
        mImageResID = imageResID;
        mGeoX = GeoX;
        mGeoY = GeoY;
    }

    public Place(String name, String location, int imageResID){
        mName = name;
        mLocation = location;
        mImageResID = imageResID;
    }

    public String getPlaceName(){return  mName;}

    public String getPlaceLocation(){return mLocation;}

    public int getPlaceImage(){return mImageResID;}

    public double getGeoX(){return mGeoX;}

    public double getGeoY(){return mGeoY;}
}
