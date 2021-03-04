package com.example.authtry1;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class libweb extends AppCompatActivity {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libweb);
        webView=findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
String url=getIntent().getExtras().getString("url");
if(url==null){
    url="www.google.com";

}

        final ProgressDialog pd=new ProgressDialog(this);
        pd.setTitle(url);
        pd.setMessage("Opening....!!!");


        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pd.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pd.dismiss();
            }
        });
        webView.loadUrl(url);
    }

    }
