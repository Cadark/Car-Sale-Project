package com.heykorean.pioneer.cadark;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static int colorLineEdt;

    Button loginFragBtn, registerFragBtn;
    Fragment fragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = new LoginFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.viewArea, fragment);
        transaction.commit();

        colorLineEdt = getResources().getColor(R.color.colorPrimary);

        loginFragBtn = (Button) findViewById(R.id.loginFragBtn);
        registerFragBtn = (Button) findViewById(R.id.registerFragBtn);

        loginFragBtn.setOnClickListener(this);
        registerFragBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginFragBtn:
                changeFrag(new LoginFragment());
                break;

            case R.id.registerFragBtn:
                changeFrag(new RegisterFragment());
                break;
        }
    }

    public void changeFrag(Fragment fragment) {
        this.fragment = fragment;
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.viewArea, fragment);
        transaction.commit();
    }
}