package com.viramaham.ninjolibrary;

import android.app.Activity;
import android.os.Handler;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.InterstitialCallbacks;


public class AdsInterstitial {


    public static void CreateUnterstitial(final Activity activity, final Boolean consentValue,
                                          final Boolean isTesting,
                                          final String HashKeyNinjonics,
                                          final Boolean setAutoCache, final Boolean setcache){



        if (setcache){
            Appodeal.cache(activity, Appodeal.INTERSTITIAL);
        }
        Appodeal.setAutoCache(Appodeal.INTERSTITIAL, setAutoCache);

        Appodeal.setTesting(isTesting);
      Appodeal.initialize(activity, HashKeyNinjonics, Appodeal.INTERSTITIAL, consentValue);

        int TIME = 5000; //5000 ms (5 Seconds)

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                if (Appodeal.isLoaded(Appodeal.INTERSTITIAL)){
                    Appodeal.show(activity, Appodeal.INTERSTITIAL);
                }else {
                    AdsInterstitial.CreateUnterstitial(activity,consentValue,isTesting,HashKeyNinjonics,setAutoCache,setcache);
                }

            }
        }, TIME);




    }





    public static Boolean InterstitialIsLoaded(){
       Boolean interstitialisloaded =Appodeal.isLoaded(Appodeal.INTERSTITIAL);
       return interstitialisloaded;
    }



    public static void setInterstitialCallbacks(final onInterstitialLoaded onInterstitialLoaded, final Activity activity){

        Appodeal.setInterstitialCallbacks(new InterstitialCallbacks() {
            @Override
            public void onInterstitialLoaded(boolean b) {
                onInterstitialLoaded.onInterstitialLoaded(b);

            }

            @Override
            public void onInterstitialFailedToLoad() {
                 onInterstitialLoaded.onInterstitialFailedToLoad();
            }

            @Override
            public void onInterstitialShown() {
                onInterstitialLoaded.onInterstitialShown();
            }

            @Override
            public void onInterstitialClicked() {
                onInterstitialLoaded.onInterstitialClicked();
            }

            @Override
            public void onInterstitialClosed() {
                onInterstitialLoaded.onInterstitialClosed();
            }

            @Override
            public void onInterstitialExpired() {
                onInterstitialLoaded.onInterstitialExpired();
            }
        });
    }

    public  interface onInterstitialLoaded{
        void onInterstitialLoaded(boolean b);
         void onInterstitialFailedToLoad();
         void onInterstitialShown();
        void onInterstitialClicked();
        void onInterstitialClosed();
        void onInterstitialExpired();
    }




}
