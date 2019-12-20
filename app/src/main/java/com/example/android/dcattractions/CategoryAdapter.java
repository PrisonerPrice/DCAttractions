package com.example.android.dcattractions;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    // Context of the APP
    private Context mContext;

    // context is the context of the APP
    // fm is the fragment manager that will keep each fragment's state in the adapter across swipes
    public CategoryAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    // Return the Fragment that should be displayed for the given page number
    @Override
    public Fragment getItem(int position){
        if(position == 0){
            return new LandmarksFragment();
        } else if(position == 1){
            return new MuseumsFragment();
        } else if(position == 2){
            return new GreensFragment();
        } else {
            return new ShoppingAndDinningFragment();
        }
    }

    @Override
    public String getPageTitle(int position){
        String label;
        if(position == 0){
            label = mContext.getResources().getString(R.string.page_title_landmarks);
        } else if(position == 1){
            label = mContext.getResources().getString(R.string.page_title_museums);
        } else if(position == 2){
            label = mContext.getResources().getString(R.string.page_title_greens);
        } else {
            label = mContext.getResources().getString(R.string.page_title_shopping_and_dinning);
        }
        return label;
    }

    @Override
    public int getCount(){return 4;}

}
