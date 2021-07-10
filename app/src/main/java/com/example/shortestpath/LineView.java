package com.example.shortestpath;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class LineView extends View {

    private Paint paint = new Paint();
    private PointF pointA, pointB, pointC, pointD, pointE;
    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //properties
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        //get coordinates
        canvas.drawLine(pointA.x, pointA.y, pointB.x, pointB.y, paint);//A -> B
        canvas.drawLine(pointA.x, pointA.y, pointC.x, pointC.y,paint);// A -> C
        canvas.drawLine(pointB.x, pointB.y,pointC.x, pointC.y,paint);// B -> C
        canvas.drawLine(pointC.x, pointC.y, pointE.x, pointE.y,paint);// C -> E
        canvas.drawLine(pointC.x, pointC.y, pointD.x, pointD.y,paint);// C -> D
        canvas.drawLine(pointD.x, pointD.y, pointE.x, pointE.y,paint);//D -> E
        //draw lines
        super.onDraw(canvas);
    }
    //get coordinates method
    public void setPointA(PointF point){
        pointA = point;
    }
    public void setPointB(PointF point){
        pointB = point;
    }
    public void setPointC(PointF point){ pointC = point;}
    public void setPointD(PointF point){ pointD = point;}
    public void setPointE(PointF point){ pointE = point;}
    public void draw(){
        invalidate();
        requestLayout();
    }
}
