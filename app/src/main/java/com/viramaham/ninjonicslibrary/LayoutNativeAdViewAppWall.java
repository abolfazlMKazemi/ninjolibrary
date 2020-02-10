package com.viramaham.ninjonicslibrary;

import android.content.Context;
import android.util.AttributeSet;

import com.appodeal.ads.NativeAd;
import com.appodeal.ads.native_ad.views.NativeAdViewAppWall;

public class LayoutNativeAdViewAppWall extends NativeAdViewAppWall {
    public LayoutNativeAdViewAppWall(Context context, NativeAd nativeAd) {
        super(context, nativeAd);
    }

    public LayoutNativeAdViewAppWall(Context context, NativeAd nativeAd, String placementName) {
        super(context, nativeAd, placementName);
    }

    public LayoutNativeAdViewAppWall(Context context) {
        super(context);
    }

    public LayoutNativeAdViewAppWall(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LayoutNativeAdViewAppWall(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LayoutNativeAdViewAppWall(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
