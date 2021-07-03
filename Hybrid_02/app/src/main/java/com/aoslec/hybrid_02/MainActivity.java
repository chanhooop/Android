package com.aoslec.hybrid_02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    Button btnHello, btnImage1, btnImage2;

    String btnHelloClick = "<html>" +
            "<body>" +
            "<h1>Hello Wold!</h1>" +
            "</body>" +
            "</html>";

    String btnImageClick = "<html>" +
            "<body>" +
            "<img src=\"http://192.168.0.229:8080/test/dog.jpg\">" +
            "</body>" +
            "</html>";

    String btnImageClick2 = "<html>" +
            "<body>" +
            "<img src=\"http://192.168.0.229:8080/test/dog.jpg\" style = \"width:500px; height:500px;\">" +
            "</body>" +
            "</html>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView  = findViewById(R.id.webView);
        btnHello = findViewById(R.id.btnHello1);
        btnImage1 = findViewById(R.id.btnImage1);
        btnImage2 = findViewById(R.id.btnImage2);

        btnHello.setOnClickListener(onClickListener);
        btnImage1.setOnClickListener(onClickListener);
        btnImage2.setOnClickListener(onClickListener);

        // Web Setting
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // JavaScript 사용 가능하게 만들어줌
        webSettings.setBuiltInZoomControls(true); // 확대 축소 기능
        webSettings.setDisplayZoomControls(false); //돋보기 기능 없애기
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        if(webView.canGoBack()){
            webView.goBack();
        }else {
            finish();
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnHello1:
                    webView.loadDataWithBaseURL(null, btnHelloClick, "text/HTML", "UTF-8", null);
                    break;
                case R.id.btnImage1:
                    webView.loadDataWithBaseURL(null,btnImageClick,"text/HTML","UTF-8",null);
                    break;
                case R.id.btnImage2:
                    webView.loadDataWithBaseURL(null,btnImageClick2,"text/HTML","UTF-8",null);
                    break;
            }

        }
    };




    }

