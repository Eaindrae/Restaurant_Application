package com.padcmyanmar.padc9.restaurant_application.ViewHolders;

import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.padcmyanmar.padc9.restaurant_application.R;
import com.padcmyanmar.padc9.restaurant_application.data.vos.MenuVO;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RestaurantMenuViewHolder extends BaseViewHolder<MenuVO> {

    @BindView(R.id.tv_menu_name)
    TextView menuName;

    @BindView(R.id.tv_menu_price)
    TextView menuPrice;

    public RestaurantMenuViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindData(MenuVO data) {
        menuName.setText(data.getName());
        menuPrice.setText(data.getPrice());
    }
}
