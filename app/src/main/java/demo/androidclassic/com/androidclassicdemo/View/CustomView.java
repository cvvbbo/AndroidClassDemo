package demo.androidclassic.com.androidclassicdemo.View;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;


/**
 *
 * 可以移动的view
 *
 *
 * */
public class CustomView extends View {

    private Scroller mScroller;


    private int lastX;
    private int lastY;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);

    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y= (int) event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;

            case MotionEvent.ACTION_MOVE:
                int offsetX=x-lastX;
                int offsetY=y-lastY;

                // todo 方法一
//                layout(getLeft()+offsetX,getTop()+offsetY,
//                        getRight()+offsetX , getBottom()+offsetY);

                //todo 方法二
//                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
//                layoutParams.leftMargin=getLeft()+offsetX;
//                layoutParams.topMargin=getTop()+offsetY;
//                setLayoutParams(layoutParams);

                //使用MarginLayoutParams
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(layoutParams);

//                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)getLayoutParams();
//                layoutParams.leftMargin=getLeft()+offsetX;
//                layoutParams.topMargin=getTop()+offsetY;
//                setLayoutParams(layoutParams);

                ((View)getParent()).scrollBy(-offsetX,-offsetY);
                break;
        }

        return true;
    }

    public void smoothScrollTo(int destX,int destY){
        int scrollX=getScrollX();
        int delta=destX-scrollX;
        //1000秒内滑向destX
        mScroller.startScroll(scrollX,0,delta,0,2000);
        invalidate();
    }
    @Override
    public void computeScroll() {
        super.computeScroll();
        if(mScroller.computeScrollOffset()){
            ((View) getParent()).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            //通过不断的重绘不断的调用computeScroll方法
            invalidate();
        }

    }
}
