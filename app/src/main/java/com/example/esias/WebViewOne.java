package com.example.esias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class WebViewOne extends AppCompatActivity {
   ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_one);
        WebView webView=(WebView)findViewById(R.id.webView);
        WebSettings webSettings=webView.getSettings();
        progressBar=(ProgressBar)findViewById(R.id.webviewprogressbar);
        progressBar.setMax(100);




        webSettings.setJavaScriptEnabled(true);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
//        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(false);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

//        webSettings.setLoadWithOverviewMode(true);
//        webSettings.setEnableSmoothTransition(true);
        String url=getIntent().getStringExtra("urltoload");
        if(url.equals("https://aquibe.github.io/e-sias-syllabus/bca-2.html"))
            webView.setInitialScale(150);
        else
            webView.setInitialScale(100);

        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null && (url.startsWith("http://") || url.startsWith("https://"))) {
                    view.getContext().startActivity(
                            new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                Toast.makeText(WebViewOne.this,"Error. Please try again",Toast.LENGTH_SHORT).show();
            }
        });



    }
}
