package com.viramaham.ninjolibrary;

import android.app.Activity;
import android.os.Handler;
import android.widget.Toast;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.RewardedVideoCallbacks;

public  class AdsRewardedVideo {
    public static void CreateRewardedVideo(final Activity activity, final Boolean consentValue, final Boolean isTesting,
                                           final String HashKeyNinjonics, final Boolean setAutoCache, final Boolean setcache){

        if (setcache){
            Appodeal.cache(activity,Appodeal.REWARDED_VIDEO);
        }
        Appodeal.setAutoCache(Appodeal.REWARDED_VIDEO, setAutoCache);

        Appodeal.setTesting(isTesting);
        Appodeal.initialize(activity, HashKeyNinjonics, Appodeal.REWARDED_VIDEO, consentValue);


        int TIME = 5000; //5000 ms (5 Seconds)

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Appodeal.isLoaded(Appodeal.REWARDED_VIDEO)){
                    Appodeal.show(activity, Appodeal.REWARDED_VIDEO);
                }else {
                    Toast.makeText(activity,"rebuild",Toast.LENGTH_LONG).show();
                    AdsRewardedVideo.CreateRewardedVideo(activity,consentValue,isTesting,HashKeyNinjonics,setAutoCache,setcache);
                }


            }
        }, TIME);


    }


    public static Boolean RewardedVideoIsLoaded(){
       Boolean isLoaded= Appodeal.isLoaded(Appodeal.REWARDED_VIDEO);
       return isLoaded;
    }


    public static void setRewardedVideoCallbacks(final onRewardedVideoCallbacks onRewardedVideoCallbacks){
        Appodeal.setRewardedVideoCallbacks(new RewardedVideoCallbacks() {
            @Override
            public void onRewardedVideoLoaded(boolean isPrecache) {
                onRewardedVideoCallbacks.onRewardedVideoLoaded(isPrecache);
                // Called when rewarded video is loaded
            }
            @Override
            public void onRewardedVideoFailedToLoad() {
                // Called when rewarded video failed to load
                onRewardedVideoCallbacks.onRewardedVideoFailedToLoad();
            }
            @Override
            public void onRewardedVideoShown() {
                // Called when rewarded video is shown
                onRewardedVideoCallbacks.onRewardedVideoShown();
            }
            @Override
            public void onRewardedVideoClicked() {
                // Called when rewarded video is clicked
                onRewardedVideoCallbacks.onRewardedVideoClicked();
            }
            @Override
            public void onRewardedVideoFinished(double amount, String name) {
                // Called when rewarded video is viewed until the end
                onRewardedVideoCallbacks.onRewardedVideoFinished(amount,name);
            }
            @Override
            public void onRewardedVideoClosed(boolean finished) {
                // Called when rewarded video is closed
                onRewardedVideoCallbacks.onRewardedVideoClosed(finished);
            }
            @Override
            public void onRewardedVideoExpired() {
                // Called when rewarded video is expired
                onRewardedVideoCallbacks.onRewardedVideoExpired();
            }
        });
    }
    public  interface onRewardedVideoCallbacks{
        void onRewardedVideoLoaded(boolean b);
        void onRewardedVideoFailedToLoad();
        void onRewardedVideoShown();
        void onRewardedVideoClicked();
        void onRewardedVideoFinished(double amount, String name);
        void onRewardedVideoClosed(boolean finished);
        void onRewardedVideoExpired();
    }


    public static void UserData(Activity activity,String setuserid){
        Appodeal.getUserSettings(activity).setUserId(setuserid);
    }




}
