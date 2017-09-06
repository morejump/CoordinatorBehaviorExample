package saulmm.myapplication.Utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by morejump on 23/08/2017.
 */

public class Circle extends View {
    private static final int START_ANGLE_POINT = 90;

    private final Paint paint;
    private  RectF rect;

    private float angle;

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);

        final int strokeWidth = 10;

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        //Circle color
        paint.setColor(Color.RED);

        //size 200x200 example
        rect = new RectF(strokeWidth, strokeWidth, 200 + strokeWidth, 200 + strokeWidth);

        //Initial Angle (optional, it can be zero)
        angle = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(rect, START_ANGLE_POINT, angle, false, paint);
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
    public void setRect(View view){
        Rect viewRect =new  Rect();
        view.getHitRect(viewRect);
        Log.d("thaohandsome", "setRect: "+viewRect.left +" "+viewRect.right+" "+viewRect.bottom);
        int a=6;

        rect= new RectF(viewRect.left+a, viewRect.top+a,viewRect.right-a, viewRect.bottom-a);


    }
}
