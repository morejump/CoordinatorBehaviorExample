package saulmm.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by morejump on 25/07/2017.
 */
// Inheriting an imageview and re - draw layout by onDraw method

public class TriangleShapeView extends android.support.v7.widget.AppCompatImageView {
    public TriangleShapeView(Context context) {
        super(context);
    }

    public TriangleShapeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public TriangleShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int w = getWidth()/2;
        int h = getHeight();

        Path path = new Path();
        path.moveTo(0, 0);
        path.lineTo(h, h);
        path.lineTo(0, h);
        path.moveTo(0, 0);
        path.close();

        Paint p = new Paint();
        p.setColor( Color.WHITE );

        canvas.drawPath(path, p);
    }

}
