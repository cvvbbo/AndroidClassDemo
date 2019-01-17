package demo.androidclassic.com.androidclassicdemo.mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import demo.androidclassic.com.androidclassicdemo.R;
import demo.androidclassic.com.androidclassicdemo.databinding.TestViewBinding;

public class TestActivity extends AppCompatActivity {

    TestViewBinding  bindbing;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         bindbing=DataBindingUtil.setContentView(this, R.layout.test_view);
        MyMode myMode = new MyMode();
        bindbing.setMe(myMode);
        bindbing.tv1.setTextColor(Color.parseColor("#FF83FA"));
        // todo 初始化不能改变textview的值
        bindbing.tv1.setText("hahahahahha");
        bindbing.tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestActivity.this,"haha",Toast.LENGTH_SHORT).show();
                //todo 但是在这里却能改变textview的值
                bindbing.tv1.setText("hahahahahha");

            }
        });

    }


}
