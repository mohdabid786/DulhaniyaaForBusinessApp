package com.dulhaniyaa.dulhaniyaaforbusinessapp.util;

import android.databinding.BindingAdapter;
import android.widget.TextView;

public class FontBinding {
    @BindingAdapter({"bind:font"})
    public static void setFont(TextView textView, String fontName) {
        textView.setTypeface(CustomFontFamily.getInstance().getFont(fontName));
    }
}
