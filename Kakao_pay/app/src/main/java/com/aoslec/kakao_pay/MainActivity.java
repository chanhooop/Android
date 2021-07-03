package com.aoslec.kakao_pay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editName);
        editTextPrice = findViewById(R.id.editPrice);

        // 버튼 클릭 이벤트
        Button button = findViewById(R.id.buttonPay);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText에 입력한 상품 정보를 가져온다.
                Log.v("fff","onClick");
                String name = editTextName.getText().toString();
                String price = editTextPrice.getText().toString();

                // 결제가 이루어지는 PayActivity를 생성한다.
                // - 생성자를 이용하여 상품 정보를 입력한다.
                PayActivity payActivity = new PayActivity(name, price);

                // Intent로 새로운 Activity를 실행한다.
                Intent intent = new Intent(getApplicationContext(), payActivity.getClass());
                startActivity(intent);
                Log.v("fff","startActivity");
//                Intent intent = new Intent(MainActivity.this, PayActivity.class);
//                intent.putExtra("name", name);
//                intent.putExtra("price", price);
//                startActivity(intent);
            }
        });


        // 결제 요청 단계 - 통신을 받을 Response 변수
        Response.Listener<String> approvalResponse = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Debug", response);
            }
        };

    }
}