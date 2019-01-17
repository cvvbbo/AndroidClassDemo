package demo.androidclassic.com.androidclassicdemo.Testviewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class Myflowlayout1 extends ViewGroup {

    // 3669 4388 4717x2 4441  7816 5271 5126 5622x3 6100x2


    /**
     *  这个是能够装很多个textview的 viewgroup ！！
     *
     *  横向装很多个view
     *
     *  还是存在缺陷，如何margin的值怎么设置
     *
     *
     *
     *
     * */


    public Myflowlayout1(Context context) {
        super(context);
    }

    public Myflowlayout1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Myflowlayout1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    // todo 测量这个方法会不断的测量，不只是走一次
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
            // todo 这里算的时候没有把边距算进去
            linewidth += childAtWidth+100;
            lineheight = childAtHeight;

            //第二行的时候(或者)是换行的时候
            if (linewidth >= widthsize) {

                int num = (int) Math.ceil(linewidth / widthsize);
                for (int j=0;j<num;j++) {
                    lineheight += childAtHeight+20;
                }
            }

        }

        //测量自己  （测量自己肯定是通过getmode和getsize方法得来的）
        // todo exactly（精确的）(精确的包裹match_parent)
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

        int lineheight=0;
        int linewidth=0;

        Log.e("--边距的距离是--","-left-"+l+"-top-"+t+"-r-"+r+"-b-"+b);
        int childCount = getChildCount();
        int left=0;
        int top=0;
        for (int i=0;i<childCount;i++) {
            View childAt = getChildAt(i);
            //  todo onlayout 方法中 的左上右下，右边的坐标是比左边的坐标要大的！！，也属于常识！！！
            childAt.layout(left, top, childAt.getMeasuredWidth()+left, childAt.getMeasuredHeight()+top);
            //  todo 宽度100是自己加的view 和 view 边之间的间距
            left+=childAt.getMeasuredWidth()+100;

            //第二行的时候(或者)是换行的时候
            int childWidth = childAt.getMeasuredWidth();
            int childheight = childAt.getMeasuredHeight();

            int width = getWidth();
            // todo 100是间距，自己设置的，这里减去100，因为debug的时候发现，已经是添加了长度之后的
            if ((left -100)> width) {
                left=0;
                top += childheight+20;
                childAt.layout(left, top, childAt.getMeasuredWidth()+left, childAt.getMeasuredHeight()+top);
                left+=childAt.getMeasuredWidth()+100;

            }
        }

    }


}
