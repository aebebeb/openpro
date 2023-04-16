package com.example.project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class SecondActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("투표 결과");

//메인이 넘긴 인텐트를 getIntent()로 받고, 이를 따로 저장
        Intent intent=getIntent();
        int[] voteResult=intent.getIntArrayExtra("VoteCount");
        String[] imageName=intent.getStringArrayExtra("ImageName");

        TextView tv[]=new TextView[imageName.length];
        RatingBar rbar[]=new RatingBar[imageName.length];

        Integer tvId[]={R.id.tv2, R.id.tv2, R.id.tv3,
                R.id.tv4, R.id.tv5, R.id.tv6,R.id.tv7, R.id.tv8, R.id.tv9};
        Integer rbarId[]= {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4,
                R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};

//위젯 ID배열에 위젯을 대입
        for(int i=0; i<voteResult.length; i++) {
            tv[i]=(TextView)findViewById(tvId[i]);
            rbar[i]=(RatingBar)findViewById(rbarId[i]);
        }

//각 텍스트뷰와 레이팅바에, 넘겨받은 그림파일 이름이나 투표수를 적용
        for(int i=0; i<voteResult.length; i++){
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }

        Button btnReturn=(Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                finish();
            }
        });
    }
}