package com.viramaham.ninjonicslibrary;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.AppodealNetworks;
import com.appodeal.ads.Native;
import com.appodeal.ads.NativeAd;
import com.appodeal.ads.native_ad.views.NativeAdViewAppWall;
import com.appodeal.ads.native_ad.views.NativeAdViewContentStream;
import com.appodeal.ads.native_ad.views.NativeAdViewNewsFeed;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




      //  AdsInterstitial.CreateUnterstitial(this,true,true,"b339b8f20d93cbc42699c25cfa5fbdc03006d015fcce1567",true,true);

        //AdsRewardedVideo.CreateRewardedVideo(this,true,true,"b339b8f20d93cbc42699c25cfa5fbdc03006d015fcce1567",false,true);

       // AdsNonSkippableVideo.CreateNonSkippableVideo(activity,true,true,"b339b8f20d93cbc42699c25cfa5fbdc03006d015fcce1567",false,true);


        TextView textView=findViewById(R.id.textView2);
        final Activity activity=this;



        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Toast.makeText(activity,AdsRewardedVideo.RewardedVideoIsLoaded()+"load",Toast.LENGTH_LONG).show();
               AdsNative.CreateNativeAds(activity,true,true,"b339b8f20d93cbc42699c25cfa5fbdc03006d015fcce1567",false,true);

               AdsNative.setNativeAdsCallbacks(new AdsNative.NativeAdsCallbacks() {
                   @Override
                   public void onNativeLoaded() {
                       List<NativeAd> list= AdsNative.getNativeAds(4);
                       NativeAdViewNewsFeed nav_nf = findViewById(R.id.native_ad_view_news_feed);
                       nav_nf.setNativeAd(list.get(0));

                       NativeAdViewAppWall nav_aw = findViewById(R.id.native_ad_view_app_wall);
                       nav_aw.setNativeAd(list.get(0));

                       NativeAdViewContentStream nav_cs =findViewById(R.id.native_ad_view_content_stream);
                       nav_cs.setNativeAd(list.get(0));
                       //  nav_aw.showSponsored(true);
                       // nav_aw.setCallToActionColor(int color)
                       //nav_aw.setCallToActionColor(String color)

                   }

                   @Override
                   public void onNativeFailedToLoad() {

                   }

                   @Override
                   public void onNativeShown(NativeAd nativeAd) {

                   }

                   @Override
                   public void onNativeClicked(NativeAd nativeAd) {

                   }

                   @Override
                   public void onNativeExpired() {

                   }
               });
*/
            }
        });

/*
      textView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //exaple of custom


          }
      });*/

/*
textView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        AdsBanner.CreateBanner(activity,true,false,"b339b8f20d93cbc42699c25cfa5fbdc03006d015fcce1567",false,true,AdsBanner.Bottom);


    }
});
*/

/*
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AdsMRCE.CreateMRCEUseLayout(activity,true,true,"b339b8f20d93cbc42699c25cfa5fbdc03006d015fcce1567",false,true,R.id.appodealMrecView);
                }
            });
*/

    }
}
