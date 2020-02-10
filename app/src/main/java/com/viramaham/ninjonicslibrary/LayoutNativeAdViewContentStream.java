package com.viramaham.ninjonicslibrary;

import android.content.Context;
import android.util.AttributeSet;

import com.appodeal.ads.NativeAd;
import com.appodeal.ads.native_ad.views.NativeAdViewContentStream;

public class LayoutNativeAdViewContentStream extends NativeAdViewContentStream {
    public LayoutNativeAdViewContentStream(Context context, NativeAd nativeAd) {
        super(context, nativeAd);
    }

    public LayoutNativeAdViewContentStream(Context context, NativeAd nativeAd, String placementName) {
        super(context, nativeAd, placementName);
    }

    public LayoutNativeAdViewContentStream(Context context) {
        super(context);
    }

    public LayoutNativeAdViewContentStream(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LayoutNativeAdViewContentStream(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LayoutNativeAdViewContentStream(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
