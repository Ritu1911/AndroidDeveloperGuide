package com.kammo.alokrabi.be_a_android_developer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.kammo.alokrabi.be_a_android_developer.Common.Common;

public class Supporting_Differ_Dev extends AppCompatActivity {
    Toolbar toolbar;
    private AdView mAdView ;
    WebView view;
    Button btn;
    ProgressBar mProgress;
    private InterstitialAd interstitialAd;
    private final String googleDocs = "https://docs.google.com/viewer?url=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supporting__differ__dev);
        ///Interstitial Ads
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        interstitialAd.loadAd(new AdRequest.Builder().build());

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {

                startActivity(new Intent(Supporting_Differ_Dev.this,MainActivity.class));
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });


        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Supporting_Differ_Dev.this, LangAndCult.class);
                startActivity(i2);
            }
        });
        mProgress = (ProgressBar)findViewById(R.id.mProgress);
        final ProgressDialog mDialog1 = new ProgressDialog(Supporting_Differ_Dev.this);
        mDialog1.setIcon(R.mipmap.ic_launcher);
        mDialog1.setTitle("Android Training");
        mDialog1.setMessage("Loading .....");


        // MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        Runnable progressRunnable = new Runnable() {

            @Override
            public void run() {
                mDialog1.cancel();
            }
        };
        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 5000);




        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Supporting Differnt Devices");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (interstitialAd.isLoaded()) {
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(Supporting_Differ_Dev.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        String url = "https://developer.android.com/training/basics/supporting-devices/index.html";
        view = (WebView) findViewById(R.id.webview);

        if (Common.isConnectedToInternet(getBaseContext())) {
            //mDialog1.show();
            WebSettings webSettings = view.getSettings();
            webSettings.setJavaScriptEnabled(true);
            view.loadUrl(url);
            view.setWebViewClient(new WebViewClient(){
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    mProgress.setVisibility(View.VISIBLE);
                    Log.i("progressBar", "Visible");
                    super.onPageStarted(view, url, favicon);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    Log.i("pageFinished", "yesss");
                    mProgress.setVisibility(View.INVISIBLE);
                    Log.i("progressBar", "Gone");

                }
                @Override
                public void onPageCommitVisible(WebView view, String url) {

                    super.onPageCommitVisible(view, url);
                    mProgress.setVisibility(View.INVISIBLE);
                }
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    if (url.endsWith(".pdf")){
                        String pdfUrl = googleDocs + url;
                        view.loadUrl(pdfUrl);
                    } else {
                        view.loadUrl(url);
                    }
                    return true;
                }
            });

           /*
            mDialog1.getMax();
            view.getSettings().setJavaScriptEnabled(true);
            view.loadUrl(url);*/


        } else
        {
            Intent intent = new Intent(Supporting_Differ_Dev.this, NoInternet.class);
            startActivity(intent);
            Toast.makeText(this, "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
            return;
        }


    }

    @Override
    public void onBackPressed() {
        if (view.canGoBack()){
            view.goBack();
        }else {
            super.onBackPressed();
        }
    }
}



