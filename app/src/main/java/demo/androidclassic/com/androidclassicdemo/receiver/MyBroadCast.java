package demo.androidclassic.com.androidclassicdemo.receiver;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
/**
 *
 * @author Android将军
 *
 */
public class MyBroadCast extends BroadcastReceiver{

    public MyBroadCast()
    {
        Log.v("BROADCAST_TAG", "MyBroadCast");
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Log.v("BROADCAST_TAG", "onReceive");
        Bundle bundle = intent.getExtras();
        if(intent.getAction().equals(MainActivity.ACTION_INTENT_TEST))
        {
            processCustomMessage(context, bundle);
        }
    }
    //send msg to MainActivity
    private void processCustomMessage(Context context, Bundle bundle) {

        Intent mIntent=new Intent(MainActivity.ACTION_INTENT_RECEIVER);
        mIntent.putExtra("message", "测试Broadcast与Activity之间的通信");
        context.sendBroadcast(mIntent);

    }

}
