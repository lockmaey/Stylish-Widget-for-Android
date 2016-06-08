package com.app.infideap.stylishwidget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;


/**
 * Created by Zariman on 13/4/2016.
 */
public class ATextInputEditText extends TextInputEditText {
    public ATextInputEditText(Context context) {
        super(context);
        setCustomTypeface(context, null);

    }

    public ATextInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomTypeface(context, attrs);

    }

    public ATextInputEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomTypeface(context, attrs);

    }

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
