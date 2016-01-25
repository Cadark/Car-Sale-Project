package com.heykorean.pioneer.cadark;

import android.graphics.PorterDuff;
import android.widget.EditText;

/**
 * Created by Android on 1/22/2016.
 */
public class SetLineColorEdittext {
    public SetLineColorEdittext(EditText editText, int color) {
        editText.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }
}
