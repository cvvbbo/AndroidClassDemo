package demo.androidclassic.com.androidclassicdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class Myimageview extends android.support.v7.widget.AppCompatImageView {

    Paint paint;
    public Myimageview(Context context) {
        super(context);
    }

    public Myimageview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Myimageview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(LAYER_TYPE_SOFTWARE, null);//对单独的View在运行时阶段禁用硬件加速
        paint= new Paint(); //初始化画笔，为后面阴影效果使用。
        paint.setColor(Color.RED);
        paint.setStrokeWidth(2);
        paint.setAntiAlias(true);
        paint.setTextSize(50);
        paint.setShadowLayer(5, 15, 20, Color.GREEN);
    }


}
