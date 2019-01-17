package demo.androidclassic.com.androidclassicdemo;

import android.graphics.Color;
import android.graphics.Outline;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sxu.shadowdrawable.ShadowDrawable;

import demo.androidclassic.com.androidclassicdemo.View.CustomView;
import demo.androidclassic.com.androidclassicdemo.receiver.MainActivity;

public class TestStatbarActivity extends AppCompatActivity {
    private TextView tv;
    private ImageView im;


    //  透明的状态栏？？
    //  https://blog.csdn.net/zjt593688/article/details/52606980

    // todo 把状态栏的属性设置为透明即可

    private CustomView mCustomView;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setTheme(R.style.AppTheme1);
        setContentView(R.layout.status_act_view);
        tv = (TextView) findViewById(R.id.tv);
        im = (ImageView) findViewById(R.id.im);

        mCustomView= (CustomView) this.findViewById(R.id.R_id_customview);
        mCustomView.smoothScrollTo(-400,0);
       // hehe();

    }

    public void haha(View view){
       // Toast.makeText(view.getContext(),"hahaha",Toast.LENGTH_LONG).show();

    }

    public void hehe(){
        double result=1;
        double newresult=0;
        for (int i=0;i<365;i++){
            newresult=((result*0.01)+result);
            result=newresult;
        }
        Log.e("-total--",result+"");
    }




}
