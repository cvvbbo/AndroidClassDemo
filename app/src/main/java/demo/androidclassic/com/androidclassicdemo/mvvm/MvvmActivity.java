package demo.androidclassic.com.androidclassicdemo.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import demo.androidclassic.com.androidclassicdemo.R;
import demo.androidclassic.com.androidclassicdemo.databinding.MvvmActBinding;



public class MvvmActivity extends AppCompatActivity {


    private userbean userbean1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvvm_act);
//        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.mvvm_act);
//        userbean userbean = new userbean("熊", "bear");
//       // binding.setVariable(userbean);
//        binding.setuserbean();
      // MvvmactBindding DataBindingUtil.setContentView(this,R.layout.mvvm_act);

        // todo 下面这个  MvvmActBinding  类并不是通过快捷键生成的
        // todo  而是首先先写出后面的语句，然后通过rebuild或则clear，之后能得到
        // todo  前面的xxxbingding

        userbean userbean1 = new userbean("熊", "bear");
        MvvmActBinding binding=DataBindingUtil.setContentView(this,R.layout.mvvm_act);
        binding.setUser1111(userbean1);


    }
}
