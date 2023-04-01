package com.cookandroid.project7_2.0;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

public class MainActivity extends AppCompatActivity {

    private LinearLayoutCompat baseLayout;
    private Button btnBackgroundChange, btnButtonChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기(컨텍스트 메뉴)");

        init();
    }
    public void init(){
        baseLayout = (LinearLayoutCompat)findViewById(R.id.baseLayout);
        btnBackgroundChange = findViewById(R.id.btnBackgroundChange);
        registerForContextMenu(btnBackgroundChange);
        btnButtonChange = findViewById(R.id.btnButtonChange);
        registerForContextMenu(btnButtonChange);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();
        if(v == btnBackgroundChange){
            menu.setHeaderTitle("배경색 변경");
            mInflater.inflate(R.menu.menu1, menu);
        }
        if(v == btnButtonChange){
            mInflater.inflate(R.menu.menu2, menu);
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.subRotate:
                btnBackgroundChange.setRotation(45);
                return true;
            case R.id.subSizeUp:
                btnButtonChange.setScaleX(2);
                return true;
        }
        return false;
    }
}