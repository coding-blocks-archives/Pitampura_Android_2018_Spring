package com.codingblocks.fragments;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class DynamicFragmentActivity extends AppCompatActivity {

    Button btnTop, btnBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        btnBottom = findViewById(R.id.btnBottom);
        btnTop = findViewById(R.id.btnTop);

        final FragmentManager fragMan =  getSupportFragmentManager();
        View.OnClickListener btnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragTxn = fragMan.beginTransaction();
                switch (v.getId()) {
                    case R.id.btnBottom:
                        BottomFragment bottomFragment = new BottomFragment();
                        fragTxn.replace(R.id.flContainer, bottomFragment);
                        fragTxn.commit();
                        break;
                    case R.id.btnTop:
                        TopFragment topFragment = new TopFragment();
                        fragTxn.replace(R.id.flContainer, topFragment);
                        fragTxn.commit();
                        break;
                }
            }
        };

        btnTop.setOnClickListener(btnClickListener);
        btnBottom.setOnClickListener(btnClickListener);


    }
}
