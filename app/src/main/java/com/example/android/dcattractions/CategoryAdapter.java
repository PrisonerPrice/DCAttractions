package com.example.android.dcattractions;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    // Context of the APP
    private Context mContext;

    private LandmarksFragment landmarksFragment = new LandmarksFragment();
    private MuseumsFragment museumsFragment = new MuseumsFragment();
    private GreensFragment greensFragment = new GreensFragment();
    private ShoppingAndDinningFragment shoppingAndDinningFragment = new ShoppingAndDinningFragment();

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
            return landmarksFragment;
        } else if(position == 1){
            return museumsFragment;
        } else if(position == 2){
            return greensFragment;
        } else {
            return shoppingAndDinningFragment;
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
