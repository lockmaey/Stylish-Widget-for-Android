package com.app.infideap.stylishwidget.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;
import android.widget.CheckBox;


/**
 * Created by Zariman on 13/4/2016.
 */
public class ACheckBox extends AppCompatCheckBox {
    public ACheckBox(Context context) {
        super(context);
        setCustomTypeface(context,null);

    }

    public ACheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomTypeface(context,attrs);

    }

    public ACheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomTypeface(context,attrs);

    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    public ACheckBox(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//        setCustomTypeface(context,attrs);
//    }


    private void setCustomTypeface(Context context, AttributeSet attrs) {
        if(isInEditMode())
            return;
        TypedArray a = context.obtainStyledAttributes(attrs, android.support.v7.appcompat.R.styleable.TextAppearance);
        int style = a.getInt(android.support.v7.appcompat.R.styleable.TextAppearance_android_textStyle, Typeface.NORMAL);

        setTextStyle(style);
        a.recycle();

    }

    public void setTextStyle(int style) {
        String font;
        switch (style) {
            case Typeface.BOLD:
                font = Stylish.FONT_BOLD;
                break;
            case Typeface.ITALIC:
                font = Stylish.FONT_ITALIC;
                break;
            case Typeface.NORMAL:
                font = Stylish.FONT_REGULAR;
                break;
            default:
                font = Stylish.FONT_REGULAR;
        }

        try {

            setTypeface(Stylish.getInstance().getTypeface(getContext(), font, getTypeface()));
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

}
