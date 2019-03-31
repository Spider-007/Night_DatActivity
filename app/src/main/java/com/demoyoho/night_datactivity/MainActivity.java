package com.demoyoho.night_datactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * @author yjh
 * msg:日夜間模式的切換
 * // FIXME: 2019/3/30
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "YJH";
    private Button btn;
    private int theme = R.style.DayAppTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            /**
             * 调用生命周期就会走该方法
             * */
            theme = savedInstanceState.getInt("theme");
            setTheme(theme);
            Log.e(TAG, "onCreate: savedInstanceState");
        }
        Log.e(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn_theme);
        btn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: " );
    }

    @Override
    public void onClick(View v) {
        theme = (theme == R.style.DayAppTheme) ? R.style.NightAppTheme : R.style.DayAppTheme;
        Log.e(TAG, "onClick: ");
        MainActivity.this.recreate();
        Log.e(TAG, "onClick: recreate");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        /**
         * putInt（ String key，int value）
         * 将int值插入此Bundle的映射中，替换给定键的任何现有值。
         *
         * Bundle 就好比一个信封 里面有很多信件
         * 而我们需要把信件存放到信封里 怎么存 就需要put进去
         * 给每一个信件一个名字 这个名字就是这个信件
         *                key                 values
         * */
        outState.putInt("theme", theme);
        Log.e(TAG, "onSaveInstanceState: ");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        theme = savedInstanceState.getInt("theme");
        Log.e(TAG, "onRestoreInstanceState: ");
    }
}