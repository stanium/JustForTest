package com.aawant.aframework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.FrameLayout;
import android.widget.ListView;

public abstract class BaseActivity extends Activity {
    ListView listView;
    FrameLayout frameLayout;

    void FromOneActivityToAnother(Context c,Class<?>cls) {
        Intent intent = new Intent();
        intent.setClass(c,cls);
        startActivity(intent);
    }

    protected abstract void test();

    public abstract void test2();
}
