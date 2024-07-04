package com.zyron.assetstudio.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import com.zyron.assetstudio.R;

public class DrawerHeader extends AppCompatImageView {

    private int mWidthRatio;
    private int mHeightRatio;

    public DrawerHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DrawerHeader);
    }
}
