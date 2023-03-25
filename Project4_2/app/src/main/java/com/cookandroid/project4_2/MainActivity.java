package com.cookandroid.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    CheckBox chkAgree;
    TextView text1, text2;
    RadioGroup rGroup1;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnOK;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("애완동물 사진보기");
        chkAgree = findViewById(R.id.check1);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        rGroup1 = findViewById(R.id.radiogroup);
        rdoDog = findViewById(R.id.rdoDog);
        rdoCat = findViewById(R.id.rdoCat);
        rdoRabbit = findViewById(R.id.rdoRabbit);
        btnOK = findViewById(R.id.btn1);
        imgPet = findViewById(R.id.image);


        // 라디오 박스 클릭시마다 이미지 변경
        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                if (i == R.id.rdoDog)
                {
                    imgPet.setImageResource(R.drawable.dog);
                } else if (i == R.id.rdoCat)
                {
                    imgPet.setImageResource(R.drawable.cat);
                } else
                {
                    imgPet.setImageResource(R.drawable.rabbit);
                }
            }
        });


        // 선택완료 버튼을 클릭 하면 이미지 변경
        btnOK.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                switch (rGroup1.getCheckedRadioButtonId())
                {
                    case R.id.rdoDog:
                        imgPet.setImageResource(R.drawable.dog);
                        break;
                    case R.id.rdoCat:
                        imgPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rdoRabbit:
                        imgPet.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // onclick으로도 가능하다. ischeecked() 사용
        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean a)
            {
                if (a == true)
                {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                } else
                {

                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });


    }
}