package com.example.shapes;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;

public class Triangle extends Shape {
    Path path;
    PointF cornerLT;
    PointF cornerLB;
    PointF cornerRB;

    public Triangle(String color,PointF cornerLT, PointF cornerLB, PointF cornerRB) {
        super(color);
        this.cornerLT = cornerLT;
        this.cornerLB = cornerLB;
        this.cornerRB = cornerRB;
        path = new Path();

    }
    private Path instance(){
        path.setFillType(Path.FillType.EVEN_ODD);
        path.setLastPoint(cornerLT.x, cornerLT.y);
        path.lineTo(cornerLT.x, cornerLT.y);
        path.lineTo(cornerLB.x, cornerLB.y);
        path.lineTo(cornerRB.x, cornerRB.y);
        path.close();
        return path;
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.parseColor("#"+this.color));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(instance(),paint);
    }
}