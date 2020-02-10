package com.viramaham.ninjonicslibrary;

import android.app.Activity;
import android.os.Handler;
import android.widget.Toast;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.BannerCallbacks;

public class AdsBanner {

    public static int Top=1;
    public static int Bottom=2;
    public static int BannerView=3;


    public static void CreateBanner(final Activity activity, final Boolean consentValue,
                                    final Boolean isTesting,
                                    final String HashKeyNinjonics,
                                    final Boolean setAutoCache,
                                    final Boolean setcache, final int BannerPosition) {




        if (setcache){
            Appodeal.cache(activity, Appodeal.BANNER);
        }
        Appodeal.setAutoCache(Appodeal.BANNER, setAutoCache);

        Appodeal.setTesting(isTesting);
        Appodeal.initialize(activity, HashKeyNinjonics, Appodeal.BANNER, consentValue);

        int TIME = 5000; //5000 ms (5 Seconds)

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                if (Appodeal.isLoaded(Appodeal.BANNER)){
                    if (BannerPosition==Top){
                        Appodeal.show(activity, Appodeal.BANNER_TOP);
                    }if (BannerPosition==Bottom){
                        Appodeal.show(activity, Appodeal.BANNER_BOTTOM);
                    }if (BannerPosition==BannerView){
                        Appodeal.show(activity, Appodeal.BANNER_VIEW);
                    }

                }else {
                    Toast.makeText(activity,"rebuild",Toast.LENGTH_LONG).show();
                    AdsBanner.CreateBanner(activity,consentValue,isTesting,HashKeyNinjonics,setAutoCache,setcache,BannerPosition);
                }

            }
        }, TIME);

    }

    public static Boolean BannerIsLoaded(){
        Boolean BannerIsLoaded =Appodeal.isLoaded(Appodeal.BANNER);
        return BannerIsLoaded;
    }



    public static void setBannerAdsCallbacks(final onBannerLoaded onBannerLoaded){
        Appodeal.setBannerCallbacks(new BannerCallbacks() {
            @Override
            public void onBannerLoaded(int i, boolean b) {
                onBannerLoaded.onBannerLoaded(i,b);
            }

            @Override
            public void onBannerFailedToLoad() {
                onBannerFailedToLoad();
            }

            @Override
            public void onBannerShown() {
                onBannerShown();
            }

            @Override
            public void onBannerClicked() {
                onBannerClicked();
            }

            @Override
            public void onBannerExpired() {
                onBannerExpired();
            }
        });
    }
    public  interface onBannerLoaded{
        void onBannerLoaded(int height, boolean isPrecache);
        void onBannerFailedToLoad();
        void onBannerShown();
        void onBannerClicked();
        void onBannerExpired();
    }


    public static void HideBanner(Activity activity){
        Appodeal.hide(activity, Appodeal.BANNER);
    }

    public static void DestroyBanner(){
        Appodeal.destroy(Appodeal.BANNER);
    }

    public static void set728x90Banners(Boolean status){
        Appodeal.set728x90Banners(status);
    }

    public static void setBannerAnimation(Boolean status){
        Appodeal.setBannerAnimation(status);
    }

    public static void setSmartBanners(Boolean status){
        Appodeal.setSmartBanners(status);
    }



}//class
