package com.example.sine.justfortest;

import android.app.Activity;
import android.app.Fragment;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.aawant.Fragment.OFragment;
import com.sine.activity.BaseActivity;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends Activity {
    static final String TAG = "sine";

    BluetoothAdapter mBtAdapter;


    //注解


   // Button btn;

    Fragment fragment;
    OFragment oFragment;
    FrameLayout frameLayout;

    //动态加载布局
    @BindView(R.id.btn)
    Button btn;

    //动态加载xml布局
    @BindView(R.id.btn_1)
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //btn=new Button();
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   fromOneActivityToAnother(MainActivity.this, MyActivity2.class);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, BaseActivity.class);
                startActivity(intent);

            }
        });
        //getDataAsync();

    }

    void fromOneActivityToAnother(Context c, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(c, cls);
        startActivity(intent);
    }

    //同步操作
    void getDataSync() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient httpclient = new OkHttpClient();
                    Request request = new Request.Builder().url("http://www.baidu.com").build();

                    Response response = null;
                    response = httpclient.newCall(request).execute();

                    if (response.isSuccessful()) {

                        Log.d(TAG, "response.message()=" + response.message());
                        Log.d(TAG, "response.body()=" + response.body());
                        Log.d(TAG, response.body().string());
                    }
                } catch (Exception e) {

                }
            }
        }).start();

    }

    void getDataAsync() {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.baidu.com").build();

        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "get data fail");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e(TAG, "get data is ok");
                Log.e(TAG, "response.code()" + response.code());
                Log.e(TAG, "response.message()=" + response.message());
            }
        });


    }


    @OnClick(R.id.btn_1)
    public void onViewClicked() {

        fromOneActivityToAnother(MainActivity.this,BaseActivity.class);
    }
}
