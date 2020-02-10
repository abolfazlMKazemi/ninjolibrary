package com.viramaham.ninjonicslibrary;

import android.content.Context;
import android.util.AttributeSet;

import com.appodeal.ads.NativeAd;
import com.appodeal.ads.native_ad.views.NativeAdViewNewsFeed;

public class LayoutNativeAdViewNewsFeed extends NativeAdViewNewsFeed {
    public LayoutNativeAdViewNewsFeed(Context context, NativeAd nativeAd) {
        super(context, nativeAd);
    }

    public LayoutNativeAdViewNewsFeed(Context context, NativeAd nativeAd, String placementName) {
        super(context, nativeAd, placementName);
    }

    public LayoutNativeAdViewNewsFeed(Context context) {
        super(context);
    }

    public LayoutNativeAdViewNewsFeed(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LayoutNativeAdViewNewsFeed(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LayoutNativeAdViewNewsFeed(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
