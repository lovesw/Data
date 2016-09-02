package com.example.home.data;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * create time 2016/9/1
 * name loves
 */
public class blog extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        Button button = (Button) findViewById(R.id.button);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button.setOnClickListener(this);

        if (savedInstanceState != null) {
            Intent intent = getIntent();
            String params = intent.getStringExtra("usernme");
            Log.v("Mian.this", params);
        }


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Log.d("blog.this", "执行到这儿了");
//                Toast.makeText(this, "You are click button", Toast.LENGTH_SHORT).show();
                //第一种方式直接指定启动活动的名称
               /* Intent intent = new Intent(blog.this, Main.class);*/
                //第二种方式在XML中配置可以启动的活动。通过配置的名称来启动
                Intent intent = new Intent("com.example.home.data.Main");
                startActivity(intent);

                break;
            case R.id.button3:
                String params = "Hello wrold";
                Intent intent2 = new Intent("com.example.home.data.Main");
                intent2.putExtra("params", params);
                startActivity(intent2);
                break;


            case R.id.button4:
                Intent intent4 = new Intent("com.example.home.data.Main");

                //如果下一个活动结束需要向向这个活动返回参数。就必须用这个方式启动活动
                startActivityForResult(intent4, 1);
                break;
            default:
                Log.d("blog.this", "没有监听上");
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

        /**
         * 下一活动结束时候  返回给上一个活动的参数
         *
         * 1 :这个是表示返回给具体哪个活动，由启动活动时传入的数值决定
         *
         */

        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String data = intent.getStringExtra("params");
                    Log.d("blog.this", data);
                }
        }


    }





}
