package com.admobtest;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.CookieManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);

        webView.loadUrl("file:///android_asset/index.html");

        MobileAds.initialize(this, initializationStatus -> {

            AdView adView = findViewById(R.id.adView);

            adView.setAdListener(new AdListener() {

                @Override
                public void onAdLoaded() {
                    Toast.makeText(
                        MainActivity.this,
                        "AdMob: IKLAN BERJAYA LOAD",
                        Toast.LENGTH_LONG
                    ).show();
                }

                @Override
                public void onAdFailedToLoad(LoadAdError error) {
                    Toast.makeText(
                        MainActivity.this,
                        "AdMob ERROR: " + error.getCode() + " - " + error.getMessage(),
                        Toast.LENGTH_LONG
                    ).show();
                }
            });

            AdRequest request = new AdRequest.Builder().build();
            adView.loadAd(request);
        });
    }
}
