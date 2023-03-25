package com.cookandroid.project4_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnMod;
    TextView textResult;
    String num1, num2;
    double result;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("초간단 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnMod = (Button) findViewById(R.id.BtnMod);
        textResult = (TextView) findViewById(R.id.TextResult);


        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Double.parseDouble(num1) + Double.parseDouble(num2);
                textResult.setText("계산 결과 : " + result);

            }
        });


        btnSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Double.parseDouble(num1) - Double.parseDouble(num2);
                textResult.setText("계산 결과 : " + result);

            }
        });
        btnMul.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Double.parseDouble(num1) *Double.parseDouble(num2);
                textResult.setText("계산 결과 : " + result);

            }
        });


        btnDiv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num2.trim().equals("0"))
                {

                    Log.d("test", "토스트 메세지 테스트");
                    Toast.makeText(MainActivity.this, "0으로는 나눌 수 없습니다", Toast.LENGTH_SHORT).show();

                }else
                {

                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result);
                }


            }
        });


        btnMod.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)

            {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Double.parseDouble(num1) % Double.parseDouble(num2);

                textResult.setText("계산 결과 : " + result);

            }
        });
    }
}