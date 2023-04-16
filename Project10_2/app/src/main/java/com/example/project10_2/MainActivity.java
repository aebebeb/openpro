package com.example.project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 투표");

        final int voteCount[] = new int[9];
        for (int i = 0; i < 9; i++)
            voteCount[i] = 0;

        ImageView image[] = new ImageView[9];
        Integer imageId[] = {R.id.iv1, R.id.iv2, R.id.iv3,
                R.id.iv4, R.id.iv5, R.id.iv6,
                R.id.iv7, R.id.iv8, R.id.iv9};

        final String imgName[] = {"그림 1", "그림 2", "그림 3",
                "그림 4", "그림 5", "그림 6", "그림 7", "그림 8", "그림 9"};

        for (int i = 0; i < imageId.length; i++)
        {
            final int index;
            index = i;
            image[index] = (ImageView) findViewById(imageId[index]);

            image[index].setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),
                            imgName[index] + ":총 " +
                                    voteCount[index] + " 표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
        Button btnFinish = (Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);

//각각 정수형, 문자열 배열을 넘긴다
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImageName", imgName);
                startActivity(intent);
            }
        });
    }
}