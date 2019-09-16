package com.padcmyanmar.padc9.restaurant_application.fragments;

import android.view.View;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.padcmyanmar.padc9.restaurant_application.R;
import com.padcmyanmar.padc9.restaurant_application.data.model.RestaurantModelImpl;

public class BaseFragment extends Fragment {
    protected RestaurantModelImpl restaurantModelImpl;

    public BaseFragment(){
       restaurantModelImpl = RestaurantModelImpl.getObjInstance();
    }

    protected void showInfiniteSnackBar(String message){
        final Snackbar snackbar = Snackbar.make(getActivity().getWindow().getDecorView(), message, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(getResources().getString(R.string.lbl_ok), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
    }
}
