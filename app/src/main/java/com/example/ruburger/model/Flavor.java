package com.example.ruburger.model;

import com.example.ruburger.R;

public enum Flavor {
    COLA(R.drawable.flavor_cola),
    TEA(R.drawable.flavor_tea),
    JUICE(R.drawable.flavor_juice),
    LEMON_LIME(R.drawable.flavor_lemon_lime),
    ROOT_BEER(R.drawable.flavor_root_beer),
    ORANGE(R.drawable.flavor_orange),
    GRAPE(R.drawable.flavor_grape),
    CHERRY(R.drawable.flavor_cherry),
    MANGO(R.drawable.flavor_mango),
    PINEAPPLE(R.drawable.flavor_pineapple),
    STRAWBERRY(R.drawable.flavor_strawberry),
    WATERMELON(R.drawable.flavor_watermelon),
    PEACH(R.drawable.flavor_peach),
    RASPBERRY(R.drawable.flavor_raspberry),
    BLUEBERRY(R.drawable.flavor_blueberry);

    private final int drawableId;
    Flavor(int drawableId) {
        this.drawableId = drawableId;
    }
    public int getDrawableId() {
        return drawableId;
    }
}
