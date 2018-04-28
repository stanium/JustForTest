package com.sine.activity;

import android.os.Bundle;
import android.app.Activity;

import com.aawant.Fragment.OFragment;
import com.example.sine.justfortest.R;

public class BaseActivity extends Activity {

    OFragment oFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

}
