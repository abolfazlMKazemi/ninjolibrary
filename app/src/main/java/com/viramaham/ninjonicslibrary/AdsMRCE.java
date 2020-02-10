package com.viramaham.ninjonicslibrary;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.MrecCallbacks;

public class AdsMRCE {

    public static void CreateMRCEUseLayout(final Activity activity, final Boolean consentValue,
                                           final Boolean isTesting,
                                           final String HashKeyNinjonics,
                                           final Boolean setAutoCache,
                                           final Boolean setcache, final int MRCElayoutid) {

        if (setcache){
            Appodeal.cache(activity, Appodeal.MREC);
        }
        Appodeal.setAutoCache(Appodeal.MREC, setAutoCache);

        Appodeal.setTesting(isTesting);
        Appodeal.initialize(activity, HashKeyNinjonics, Appodeal.MREC, consentValue);

        int TIME = 5000; //5000 ms (5 Seconds)

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                if (Appodeal.isLoaded(Appodeal.MREC)){
                    Toast.makeText(activity,"loaded",Toast.LENGTH_LONG).show();
                       Appodeal.setMrecViewId(MRCElayoutid);
                        Appodeal.show(activity, Appodeal.MREC);

                }else {
                    Toast.makeText(activity,"rebuild",Toast.LENGTH_LONG).show();
                    AdsMRCE.CreateMRCEUseLayout(activity,consentValue,isTesting,HashKeyNinjonics,setAutoCache,setcache,MRCElayoutid);
                }

            }
        }, TIME);


    }

    public static void CreateMRCEUseProgrammatically(final Activity activity, final Boolean consentValue,
                                           final Boolean isTesting,
                                           final String HashKeyNinjonics,
                                           final Boolean setAutoCache,
                                           final Boolean setcache){


        if (setcache){
            Appodeal.cache(activity, Appodeal.MREC);
        }
        Appodeal.setAutoCache(Appodeal.MREC, setAutoCache);

        Appodeal.setTesting(isTesting);
        Appodeal.initialize(activity, HashKeyNinjonics, Appodeal.MREC, consentValue);

        int TIME = 5000; //5000 ms (5 Seconds)

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                if (Appodeal.isLoaded(Appodeal.MREC)){
                    Toast.makeText(activity,"loaded",Toast.LENGTH_LONG).show();
                    Appodeal.show(activity, Appodeal.MREC);


                }else {
                    Toast.makeText(activity,"rebuild",Toast.LENGTH_LONG).show();
                    AdsMRCE.CreateMRCEUseProgrammatically(activity,consentValue,isTesting,HashKeyNinjonics,setAutoCache,setcache);
                }

            }
        }, TIME);
    }



    public static Boolean MRCEIsLoaded(){
        Boolean BannerIsLoaded =Appodeal.isLoaded(Appodeal.MREC);
        return BannerIsLoaded;
    }

    public static View getMRCEView(Activity activity){
        View view =Appodeal.getMrecView(activity);
        return view;
    }



    public static void setMRCEAdsCallbacks(final onMRCELoaded onMRCELoaded){
        Appodeal.setMrecCallbacks(new MrecCallbacks() {
            @Override
            public void onMrecLoaded(boolean b) {
                onMRCELoaded.onMrecLoaded(b);
            }

            @Override
            public void onMrecFailedToLoad() {
                onMRCELoaded.onMrecFailedToLoad();
            }

            @Override
            public void onMrecShown() {
                onMRCELoaded.onMrecShown();
            }

            @Override
            public void onMrecClicked() {
                onMRCELoaded.onMrecClicked();
            }

            @Override
            public void onMrecExpired() {
                onMRCELoaded.onMrecExpired();
            }
        });
    }
    public  interface onMRCELoaded{
        void onMrecLoaded(boolean isPrecache);
        void onMrecFailedToLoad();
        void onMrecShown();
        void onMrecClicked();
        void onMrecExpired();
    }


    public  static void MrceInonResume(Activity activity){
        Appodeal.onResume(activity, Appodeal.MREC);
    }

    public static void HideMrce(Activity activity){
        Appodeal.hide(activity, Appodeal.MREC);
    }
    public static void DestroyMrce(){
        Appodeal.destroy(Appodeal.MREC);
    }

}//class
