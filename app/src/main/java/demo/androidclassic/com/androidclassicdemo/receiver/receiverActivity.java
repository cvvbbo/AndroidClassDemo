package demo.androidclassic.com.androidclassicdemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import demo.androidclassic.com.androidclassicdemo.R;

public class receiverActivity extends AppCompatActivity {

    // 接入智齿sdk的时候发现 广播在8。0好像不好使了


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_receiver_view);

        receiver();
    }

    public void haha(View v){
        Myreceiver myreceiver = new Myreceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("Myreceiver");
        registerReceiver(myreceiver,filter);
        Intent intent = new Intent("Myreceiver");
        // todo 这里发送广播 。真正广播接受者里面的方法是用来就是接受广播的，然后在广播接受者里面做什么事情
        sendBroadcast(intent);
    }


    // 接受别人广播的广播
    private void receiver() {
        Myreceiver1 myreceiver1 = new Myreceiver1();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("Myreceiver1");
        registerReceiver(myreceiver1,intentFilter);
    }


    // 这个是接接受别的广播的广播
    class Myreceiver1 extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("Myreceiver1")){
                String data = intent.getStringExtra("data");
                Toast.makeText(receiverActivity.this,data,Toast.LENGTH_SHORT).show();

                //再去启动第一个广播
                Intent intent1 = new Intent("Myreceiver");
                intent1.putExtra("des","666");
                context.sendBroadcast(intent1);
            }
        }
    }


}
