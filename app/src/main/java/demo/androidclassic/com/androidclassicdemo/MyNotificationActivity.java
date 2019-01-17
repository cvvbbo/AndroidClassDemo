package demo.androidclassic.com.androidclassicdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RemoteViews;
import android.widget.TextView;

public class MyNotificationActivity extends AppCompatActivity implements View.OnClickListener{


    private TextView tv_nomal;
    private TextView tv_fold;
    private TextView tv_hang;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioGroup radioGroup;


    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notification);

        tv_nomal = (TextView) findViewById(R.id.tv_nomal);
        tv_fold = (TextView) findViewById(R.id.tv_fold);
        tv_hang = (TextView) findViewById(R.id.tv_hang);
        radioButton1 = (RadioButton) findViewById(R.id.rb_public);
        radioButton2 = (RadioButton) findViewById(R.id.rb_private);
        radioButton2 = (RadioButton) findViewById(R.id.rb_secret);
        radioGroup = (RadioGroup) findViewById(R.id.rg_all);

        tv_nomal.setOnClickListener(this);
        tv_fold.setOnClickListener(this);
        tv_hang.setOnClickListener(this);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    }


    // zh这个是设置通知的属性
    private void selectNotofovatiomLevel(Notification.Builder builder) {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.rb_public:
                builder.setVisibility(Notification.VISIBILITY_PUBLIC);
                builder.setContentText("public");
                break;
            case R.id.rb_private:
                builder.setVisibility(Notification.VISIBILITY_PRIVATE);
                builder.setContentText("private");
                break;
            case R.id.rb_secret:
                builder.setVisibility(Notification.VISIBILITY_SECRET);
                builder.setContentText("secret");
                break;
            default:
                builder.setVisibility(Notification.VISIBILITY_PUBLIC);
                builder.setContentText("public");
                break;
        }
    }

    private void sendNomalNotification() {
        Notification.Builder builder = new Notification.Builder(this);
        // todo 里面的意图能够为null，就是什么也不传
        Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("hhttps://www.baidu.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, mIntent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setAutoCancel(true);
        builder.setContentTitle("普通通知");
        selectNotofovatiomLevel(builder);
        notificationManager.notify(0, builder.build());

    }

    //其实就是自定义的通知（通知栏上的样式能够自定义）
    private void sendFoldNotification() {
        Notification.Builder builder = new Notification.Builder(this);
        Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, mIntent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setAutoCancel(true);
        builder.setContentTitle("折叠式通知");
        selectNotofovatiomLevel(builder);
        //用RemoteViews来创建自定义Notification视图
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.view_fold);
        Notification notification = builder.build();
        //指定展开时的视图
        notification.bigContentView = remoteViews;
        notificationManager.notify(1, notification);
    }

    // 悬挂式通知栏在魅族手机上不能够实现
    private void sendHangNotification() {
        Notification.Builder builder = new Notification.Builder(this);
        Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, mIntent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setAutoCancel(true);
        builder.setContentTitle("悬挂式通知");
        selectNotofovatiomLevel(builder);
        //设置点击跳转
        Intent hangIntent = new Intent();
        hangIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        hangIntent.setClass(this, MyNotificationActivity.class);
        //如果描述的PendingIntent已经存在，则在产生新的Intent之前会先取消掉当前的
        PendingIntent hangPendingIntent = PendingIntent.getActivity(this, 0, hangIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setFullScreenIntent(hangPendingIntent, true);
        notificationManager.notify(2, builder.build());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_nomal:
                sendNomalNotification();
                break;
            case R.id.tv_fold:
                sendFoldNotification();
                break;

            case R.id.tv_hang:
                sendHangNotification();
                break;
        }
    }



}