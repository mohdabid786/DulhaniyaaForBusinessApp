package com.dulhaniyaa.dulhaniyaaforbusinessapp.util;

import android.app.Application;
import android.content.Context;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class BusinessApplication extends Application {
    private static Context context;
    CustomFontFamily customFontFamily;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        BusinessApplication.context = this;
        customFontFamily = CustomFontFamily.getInstance();
        // add your custom fonts here with your own custom name.
        customFontFamily.addFont("robo_black", "Roboto-Black.ttf");
        customFontFamily.addFont("robo_black_italic", "Roboto-BlackItalic.ttf");
        customFontFamily.addFont("robo_bold", "Roboto-Bold.ttf");
        customFontFamily.addFont("robo_bold_italic", "Roboto-BoldItalic.ttf");
        customFontFamily.addFont("robo_italic", "Roboto-Italic.ttf");
        customFontFamily.addFont("robo_light", "Roboto-Light.ttf");
        customFontFamily.addFont("robo_light_italic", "Roboto-LightItalic.ttf");
        customFontFamily.addFont("robo_medium", "Roboto-Medium.ttf");
        customFontFamily.addFont("robo_medium_italic", "Roboto-MediumItalic.ttf");
        customFontFamily.addFont("robo_regular", "Roboto-Regular.ttf");
        customFontFamily.addFont("robo_thin", "Roboto-Thin.ttf");
        customFontFamily.addFont("robo_thin_italic", "Roboto-ThinItalic.ttf");
        customFontFamily.addFont("robo_cond_bold", "RobotoCondensed-Bold.ttf");
        customFontFamily.addFont("robo_cond_bold_italic", "RobotoCondensed-BoldItalic.ttf");
        customFontFamily.addFont("robo_cond_italic", "RobotoCondensed-Italic.ttf");
        customFontFamily.addFont("robo_cond_light", "RobotoCondensed-Light.ttf");
        customFontFamily.addFont("robo_cond_light_italic", "RobotoCondensed-LightItalic.ttf");
        customFontFamily.addFont("robo_cond_regular", "RobotoCondensed-Regular.ttf");
        customFontFamily.addFont("test", "Calligraphunk-trial.ttf");
    }

    public static Context getContext() {
        return context;
    }

}
