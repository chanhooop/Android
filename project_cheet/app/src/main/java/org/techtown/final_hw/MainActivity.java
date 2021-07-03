package org.techtown.final_hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnNext;
    EditText edtPw;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("나의 하루 식사");

        edtPw = (EditText)findViewById(R.id.pw);
        btnNext = (Button)findViewById(R.id.btnNext);
        password = edtPw.getText().toString();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra("input",password);
                startActivity(intent);
            }
        });


    }
}
