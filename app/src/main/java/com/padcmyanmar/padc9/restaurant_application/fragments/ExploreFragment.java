package com.padcmyanmar.padc9.restaurant_application.fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.padcmyanmar.padc9.restaurant_application.Delegate.RestaurantDelegate;
import com.padcmyanmar.padc9.restaurant_application.R;




import butterknife.BindView;
import butterknife.ButterKnife;


public class ExploreFragment extends BaseFragment {

    private static ExploreFragment objInstance;
    private static RestaurantDelegate restaurantDelegate;

    public ExploreFragment(){}

    @SuppressLint("ValidFragment")
    public ExploreFragment(RestaurantDelegate restaurantDelegate){
        this.restaurantDelegate = restaurantDelegate;
    }

    public static ExploreFragment getObjInstance(RestaurantDelegate exploreDelegate){
        objInstance = new ExploreFragment(restaurantDelegate);
        return objInstance;
    }

    @BindView(R.id.et_search)
    EditText etSearch;

//    @BindView(R.id.search_input)
//    TextInputEditText searchInput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View views = inflater.inflate(R.layout.fragment_explore, container, false);
        ButterKnife.bind(this, views);
        restaurantDelegate.onGetAllRestaurantData(getActivity(), views);

        etSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keyword = etSearch.getText().toString();
                restaurantDelegate.onSearchItems(getActivity(), views, keyword);
            }
        });

        return views;
    }

}
