package com.viramaham.ninjolibrary;

import android.app.Activity;
import android.os.Handler;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.Native;
import com.appodeal.ads.NativeAd;
import com.appodeal.ads.NativeCallbacks;

import java.util.List;

public class AdsNative {

    public static void CreateNativeAds
                    (final Activity activity,
                     final Boolean consentValue, final Boolean isTesting,
                     final String HashKeyNinjonics,
                     final Boolean setAutoCache, final Boolean setcache) {
                if (setcache){
                    Appodeal.cache(activity,Appodeal.NATIVE);
                }
                Appodeal.setAutoCache(Appodeal.NATIVE, setAutoCache);
        Appodeal.setRequiredNativeMediaAssetType(Native.MediaAssetType.ALL);
        Appodeal.setRequiredNativeMediaAssetType(Native.MediaAssetType.ICON);
        Appodeal.setRequiredNativeMediaAssetType(Native.MediaAssetType.IMAGE);


                Appodeal.setTesting(isTesting);
                Appodeal.initialize(activity, HashKeyNinjonics, Appodeal.NATIVE, consentValue);
                int TIME = 5000; //5000 ms (5 Seconds)

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (Appodeal.isLoaded(Appodeal.NATIVE)){
                            Appodeal.show(activity, Appodeal.NATIVE);
                        }else {
                            AdsNative.CreateNativeAds(activity,consentValue,isTesting,HashKeyNinjonics,setAutoCache,setcache);
                        }

                    }
                }, TIME);

            }


    public static void setNativeCacheWhitamount(Activity activity,int NumberOfCache){
        Appodeal.cache(activity,Appodeal.NATIVE,NumberOfCache);
    }


    public static Boolean NativeAdsIsLoaded(){
        Boolean isLoaded= Appodeal.isLoaded(Appodeal.NATIVE);
        return isLoaded;
    }

    public static List getNativeAds(int amount){
        List nativilist= Appodeal.getNativeAds(amount);
        return nativilist;
    }

    public static void setNativeAdsCallbacks(final NativeAdsCallbacks nativeAdsCallbacks){
        Appodeal.setNativeCallbacks(new NativeCallbacks() {
            @Override
            public void onNativeLoaded() {
                nativeAdsCallbacks.onNativeLoaded();
            }

            @Override
            public void onNativeFailedToLoad() {
                nativeAdsCallbacks.onNativeFailedToLoad();
            }

            @Override
            public void onNativeShown(NativeAd nativeAd) {
                nativeAdsCallbacks.onNativeShown(nativeAd);
            }

            @Override
            public void onNativeClicked(NativeAd nativeAd) {
                nativeAdsCallbacks.onNativeClicked(nativeAd);
            }

            @Override
            public void onNativeExpired() {
                nativeAdsCallbacks.onNativeExpired();
            }
        });
    }
    public  interface NativeAdsCallbacks{
        void onNativeLoaded() ;
        void onNativeFailedToLoad();
        void onNativeShown(NativeAd nativeAd);
        void onNativeClicked(NativeAd nativeAd);
        void onNativeExpired();

    }


    public static int getAvailableNativeAdsCount(){
        int availableNativeAdsCount=Appodeal.getAvailableNativeAdsCount();
        return availableNativeAdsCount;
    }


    public static void NativeVideoSetting(Native.NativeAdType setNativeAdType){
        Appodeal.setNativeAdType(setNativeAdType);
    }




}//class
