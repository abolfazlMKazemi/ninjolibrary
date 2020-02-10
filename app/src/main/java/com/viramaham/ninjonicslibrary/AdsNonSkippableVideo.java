package com.viramaham.ninjonicslibrary;

import android.app.Activity;
import android.os.Handler;
import android.widget.Toast;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.NonSkippableVideoCallbacks;

public class AdsNonSkippableVideo {

    public static void CreateNonSkippableVideo(final Activity activity,
                                               final Boolean consentValue, final Boolean isTesting,
                                               final String HashKeyNinjonics,
                                               final Boolean setAutoCache, final Boolean setcache) {


        if (setcache){
            Appodeal.cache(activity,Appodeal.NON_SKIPPABLE_VIDEO);
        }
        Appodeal.setAutoCache(Appodeal.NON_SKIPPABLE_VIDEO, setAutoCache);

        Appodeal.setTesting(isTesting);
        Appodeal.initialize(activity, HashKeyNinjonics, Appodeal.NON_SKIPPABLE_VIDEO, consentValue);

        final int TIME = 5000; //5000 ms (5 Seconds)

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (Appodeal.isLoaded(Appodeal.NON_SKIPPABLE_VIDEO)){
                    Appodeal.show(activity, Appodeal.NON_SKIPPABLE_VIDEO);
                }else {
                    Toast.makeText(activity,"rebuid",Toast.LENGTH_LONG).show();
                    AdsNonSkippableVideo.CreateNonSkippableVideo(activity,consentValue,isTesting,HashKeyNinjonics,setAutoCache,setcache);
                }

            }
        }, TIME);


    }

    public static Boolean NonSkippableVideoIsLoaded(){
        Boolean isLoaded= Appodeal.isLoaded(Appodeal.NON_SKIPPABLE_VIDEO);
        return isLoaded;
    }


    public static void setNonSkippableVideoCallbacks(final NonSkippableVideoCallbacks nonSkippableVideoCallbacks) {
        Appodeal.setNonSkippableVideoCallbacks(new com.appodeal.ads.NonSkippableVideoCallbacks() {
            @Override
            public void onNonSkippableVideoLoaded(boolean b) {
                nonSkippableVideoCallbacks.onNonSkippableVideoLoaded(b);
            }

            @Override
            public void onNonSkippableVideoFailedToLoad() {
                    nonSkippableVideoCallbacks.onNonSkippableVideoFailedToLoad();
            }

            @Override
            public void onNonSkippableVideoShown() {
                    nonSkippableVideoCallbacks.onNonSkippableVideoShown();
            }

            @Override
            public void onNonSkippableVideoFinished() {
                nonSkippableVideoCallbacks.onNonSkippableVideoFinished();
            }

            @Override
            public void onNonSkippableVideoClosed(boolean b) {
                    nonSkippableVideoCallbacks.onNonSkippableVideoClosed(b);
            }

            @Override
            public void onNonSkippableVideoExpired() {
                    nonSkippableVideoCallbacks.onNonSkippableVideoExpired();
            }
        });
    }
    public  interface NonSkippableVideoCallbacks{
        void onNonSkippableVideoLoaded(boolean isPrecache) ;
        void onNonSkippableVideoFailedToLoad();
        void onNonSkippableVideoShown();
        void onNonSkippableVideoFinished();
        void onNonSkippableVideoClosed(boolean finished);
        void onNonSkippableVideoExpired();

    }


}
