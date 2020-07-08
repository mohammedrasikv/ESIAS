package com.example.esias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebViewOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_one);
        WebView webView=(WebView)findViewById(R.id.webView);
        String url=getIntent().getStringExtra("urltoload");
        webView.loadUrl(url);

    }
}
