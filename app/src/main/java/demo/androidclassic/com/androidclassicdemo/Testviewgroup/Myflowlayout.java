package demo.androidclassic.com.androidclassicdemo.Testviewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class Myflowlayout extends ViewGroup {

    /**
     *
     *  这个是最普通的viewgroup，里买呢包含若干个子view
     *
     *  代码实现横向
     *
     *
     *
     * */
    public Myflowlayout(Context context) {
        super(context);
    }

    public Myflowlayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Myflowlayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int parentwith=0;
        int parentheight=0;

        // todo 之所以会要宽高是因为，子view的高度会产生叠加，子view的宽度也会 ，想象一下
        // todo 上面的情况是在子view不止一个的情况下 ，如果子view只有一个，那么就不是这样的情况了
        int lineheight=0;
        int linewidth=0;


        int widthmode = MeasureSpec.getMode(widthMeasureSpec);
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);
        int  heightmode = MeasureSpec.getMode(heightMeasureSpec);
        int  heightsize = MeasureSpec.getSize(heightMeasureSpec);

        //  todo 遇到的问题1 如何换行？就是在父容器里面  解决，用父容器的测量高度和里面的子控件做对比即可。
        int childCount = getChildCount();
        for (int i=0;i<childCount;i++) {
            View childAt = getChildAt(i);
            measureChild(childAt,widthMeasureSpec,heightMeasureSpec);
            // 得到子控件的宽度
            int childAtWidth = childAt.getMeasuredWidth();
            // 得到子控件的高度
            int childAtHeight = childAt.getMeasuredHeight();


            // 第一行的时候
            linewidth = childAtWidth;
            lineheight = childAtHeight;

        }



        //测量自己  （测量自己肯定是通过getmode和getsize方法得来的）
        // todo exactly（精确的）
        if (widthmode==MeasureSpec.EXACTLY){
            parentwith=widthsize;
        }else{
            parentwith=linewidth;
        }


        if (heightmode==MeasureSpec.EXACTLY){
            parentheight=heightsize;
        }else{
            parentheight=lineheight;
        }

        setMeasuredDimension(parentwith,parentheight);

    }


    // todo  这里的左上右下是view到父容器的距离
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        Log.e("--边距的距离是--","-left-"+l+"-top-"+t+"-r-"+r+"-b-"+b);
        int childCount = getChildCount();
        int left=0;
        for (int i=0;i<childCount;i++) {
            View childAt = getChildAt(i);
            //  todo onlayout 方法中 的左上右下，右边的坐标是比左边的坐标要大的！！，也属于常识！！！
            childAt.layout(left, 0, childAt.getMeasuredWidth()+left, childAt.getMeasuredHeight());
            left+=childAt.getMeasuredWidth()+100;
        }

    }
}
