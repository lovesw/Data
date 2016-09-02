package com.example.home.data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Home on 2016/9/1.
 */
public class Main extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(this);

        //接受参数
        try {
            Intent intent = getIntent();
            if (intent != null) {
                String params = intent.getStringExtra("params");
                Log.d("Main.this", params);
                Toast.makeText(this, params, Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Log.d("Main.this", e.toString());
        }


    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Main.this, blog.class);
        startActivity(intent);

    }


    @Override
    public void onBackPressed() {//监听 返回 键值 事件

Intent intent=getIntent();
        intent.putExtra("params","这是当前活动结束后，返回给上一个活动的参数");
        setResult(RESULT_OK);
        finish();
    }


}
