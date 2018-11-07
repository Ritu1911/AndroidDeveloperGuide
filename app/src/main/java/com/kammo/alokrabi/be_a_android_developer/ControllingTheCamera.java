package com.kammo.alokrabi.be_a_android_developer;

import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.kammo.alokrabi.be_a_android_developer.Common.Common;

public class ControllingTheCamera extends AppCompatActivity {
    Toolbar toolbar;
    private AdView mAdView ;
    WebView view;
    Button btn;
    ProgressBar mProgress;
    private final String googleDocs = "https://docs.google.com/viewer?url=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controlling_the_camera);


        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(String.valueOf(R.string.banner_ad_unit_id));

        //MobileAds.initialize(getApplicationContext(),ca-app-pub-4724351043619149~7387534735);
        mAdView = (AdView)findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Controlling the Camera");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ControllingTheCamera.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mProgress = (ProgressBar)findViewById(R.id.mProgress);
        String url = "https://developer.android.com/training/camera/cameradirect.html";
        view = (WebView) findViewById(R.id.webview);

        if (Common.isConnectedToInternet(getBaseContext())) {
            // mDialog1.show();
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
            view.setDownloadListener(new DownloadListener() {

                @Override
                public void onDownloadStart(String url, String userAgent,
                                            String contentDisposition, String mimetype,
                                            long contentLength) {
                    DownloadManager.Request request = new DownloadManager.Request(
                            Uri.parse(url));
                    String fileName = url.substring(url.lastIndexOf('/') + 1);

                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); //Notify client once download is completed!
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
                    DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                    dm.enqueue(request);
                    Toast.makeText(getApplicationContext(), "Downloading File", //To notify the Client that the file is being downloaded
                            Toast.LENGTH_LONG).show();

                }
            });

           /*
            mDialog1.getMax();
            view.getSettings().setJavaScriptEnabled(true);
            view.loadUrl(url);*/


        } else
        {
            Intent intent = new Intent(ControllingTheCamera.this, NoInternet.class);
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



