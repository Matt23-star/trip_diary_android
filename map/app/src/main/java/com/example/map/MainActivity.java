package com.example.map;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.Fragment;
import android.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.*;



public class MainActivity extends Activity implements OnClickListener{

    private LinearLayout layoutProgress;
    private LinearLayout layoutMap;
    private LinearLayout layoutText;
    private LinearLayout layoutPerson;

    private  ImageButton btnProgress;
    private  ImageButton btnMap;
    private  ImageButton btnText;
    private  ImageButton btnPerson;

    private Fragment pageProgress = new ProgressFragment();
    private Fragment pageMap = new MapFragment();
    private Fragment pageText = new TextFragment();
    private Fragment pagePerson = new PersonFragment();

    private FragmentManager fm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initFragment();
        initview();
        initEvent();
        setSelct(0);
    }

    private void initFragment(){
        fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.id_content, pageProgress);
        transaction.add(R.id.id_content, pageMap);
        transaction.add(R.id.id_content, pageText);
        transaction.add(R.id.id_content, pagePerson);
        transaction.commit();
    }

    private void initview(){
        layoutProgress = (LinearLayout)findViewById(R.id.switch_progress);
        layoutMap = (LinearLayout)findViewById(R.id.switch_map);
        layoutText = (LinearLayout)findViewById(R.id.switch_text);
        layoutPerson = (LinearLayout)findViewById(R.id.switch_person);

        btnProgress =  findViewById(R.id.btnProgress);
        btnMap = (ImageButton) findViewById(R.id.btnMap);
        btnText = (ImageButton) findViewById(R.id.btnText);
        btnPerson = (ImageButton) findViewById(R.id.btnPerson);
    }

    private void setSelct(int i){
        FragmentTransaction transaction =fm.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 1:
                transaction.show(pageProgress);
                break;
            case 2:
                transaction.show(pageMap);
                break;
            case 3:
                transaction.show(pageText);

                break;
            case 4:
                transaction.show(pagePerson);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    //隐藏fragment
    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(pageProgress);
        transaction.hide(pageMap);
        transaction.hide(pageText);
        transaction.hide(pagePerson);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.switch_progress:
                setSelct(1);
                break;
            case R.id.switch_map:
                setSelct(2);
                break;
            case R.id.switch_text:
                setSelct(3);
                break;
            case R.id.switch_person:
                setSelct(4);
                break;
        }
    }

    private void initEvent(){
        layoutProgress.setOnClickListener(this);
        layoutMap.setOnClickListener(this);
        layoutText.setOnClickListener(this);
        layoutPerson.setOnClickListener(this);
    }

}
