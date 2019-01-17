package demo.androidclassic.com.androidclassicdemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Myreceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

       if (intent.getAction().equals("Myreceiver")) {
           intent.putExtra("data","发送");
           // todo 下面是开启了另一个广播
           Intent intent1 = new Intent("Myreceiver1");
           intent1.putExtra("data","2333333");
           context.sendBroadcast(intent1);


           String des = intent.getStringExtra("des");
           if (des==null||des.equals("")){
               Toast.makeText(context,"暂时没有值",Toast.LENGTH_SHORT).show();
           }else {
               Toast.makeText(context, des, Toast.LENGTH_SHORT).show();
           }
       }

    }
}
