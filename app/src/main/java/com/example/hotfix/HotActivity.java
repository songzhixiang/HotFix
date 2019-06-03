package com.example.hotfix;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.FileUtils;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class HotActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Tinker.HotActivity";

    private Button mRequestButton;
    private Button mBugButton;
    private Button mFetch;
    private Button mClean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug);

        Log.e(TAG, "I am on onCreate classloader123:" + MainActivity.class.getClassLoader().toString());


        mRequestButton = findViewById(R.id.btn_fix);
        mBugButton = findViewById(R.id.btn_bug);
        mFetch = findViewById(R.id.btn_fetchDynamic);
        mClean = findViewById(R.id.btn_cleanAll);
        mRequestButton.setOnClickListener(this);
        mBugButton.setOnClickListener(this);
        mFetch.setOnClickListener(this);
        mClean.setOnClickListener(this);
    }


    public static void start(Context context) {
        Intent starter = new Intent(context, HotActivity.class);

        context.startActivity(starter);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_fix:
                String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk";
                if (FileUtils.isFileExists(path)){
                    TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), path);

                }
                break;

            case R.id.btn_bug:

                int a = 10;

                int b = 1;

                Toast.makeText(this, a / b, Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_fetchDynamic:

                break;

            case R.id.btn_cleanAll:

                break;

            default:
                break;
        }
    }


    @Override
    protected void onResume() {
        Log.e(TAG, "I am on onResume hehehe");
        super.onResume();

    }

    @Override
    protected void onPause() {
        Log.e(TAG, "I am on onPause gogogo");
        super.onPause();
    }
}
