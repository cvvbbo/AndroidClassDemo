package demo.androidclassic.com.androidclassicdemo.receiver;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import demo.androidclassic.com.androidclassicdemo.R;


public class MainActivity extends Activity {
    private Button mButton;
    private TextView mTextView;
    public static String ACTION_INTENT_TEST = "com.gc.broadcase.test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        mTextView = (TextView) findViewById(R.id.message_tv);
        mButton = (Button) findViewById(R.id.send_btn);
        mButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent mIntent = new Intent(ACTION_INTENT_TEST);
                sendBroadcast(mIntent);
            }
        });
        registerMessageReceiver();
    }
    //在销毁时要与广播解绑
    @Override
    protected void onDestroy() {
        unregisterReceiver(mMessageReceiver);
        super.onDestroy();
    }

    public MessageReceiver mMessageReceiver;
    public static String ACTION_INTENT_RECEIVER = "com.gc.broadcast.receiver";

    /**
     * 动态注册广播
     */
    public void registerMessageReceiver() {
        mMessageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();

        filter.addAction(ACTION_INTENT_RECEIVER);
        registerReceiver(mMessageReceiver, filter);
    }

    public class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            if (intent.getAction().equals(ACTION_INTENT_RECEIVER)) {
                mTextView.setText(intent.getStringExtra("message"));
            }
        }

    }
}

