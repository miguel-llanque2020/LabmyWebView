package com.example.labmywebmigeul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    //private static String DIRECTION = "https://levelup.gitconnected.com/open-pdf-files-in-android-without-webviews-or-intents-3cc960752cca";
    //private static String DIRECTION       = "http://10.0.2.2/ejemplo/index.html";
    private static String DIRECTION     = "http://192.168.1.7/ejemplo/index.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           WebView webView = (WebView)findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInterface(this),"Android");

          webView.setWebViewClient(new MyWebViewClient());
         webView.loadUrl(DIRECTION);

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView webView = (WebView)findViewById(R.id.webView);
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}