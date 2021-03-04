package com.example.authtry1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class librarywebview extends AppCompatActivity {
    WebView webView;
    String  url;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_librarywebview);
        url = getIntent().getExtras().getString("url");
        webView.setWebViewClient(new WebBrowser());
        webView.getSettings().setJavaScriptEnabled(true);
        webView = findViewById(R.id.libwebview);
        webView.loadUrl(url);
    }
    private class WebBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
            webView.goBack();
        else
        super.onBackPressed();
    }
}
