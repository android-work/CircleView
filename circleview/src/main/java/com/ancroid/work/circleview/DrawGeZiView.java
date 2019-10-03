package com.ancroid.work.circleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author Mr.Liu
 */
public class DrawGeZiView extends View {

    private Paint paint;
    private int geZiCount = 960;
    private int fillCount = 80;
    private Paint fillPaint;
    private int remaineGezi;
    private int geZiWidth;
    private int defaultSize = 0;
    private int mWidth;
    private int mHeight;
    private Paint bgPaint;
    private int bgColor = Color.YELLOW;
    private int geZiStroke;
    private int line;
    private int widthCount;

    public DrawGeZiView(Context context) {
        this(context,null,0);
    }

    public DrawGeZiView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DrawGeZiView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        geZiWidth = dip2px(context,15);

        initView();
    }

    public void setGeZiLinecolor(int color){
        paint.setColor(color);
        invalidate();
    }

    public void setFillCount(int fillCount){
        this.fillCount = fillCount;
    }

    public void setFillColor(int color){
        fillPaint.setColor(color);
        invalidate();
    }

    public void setGeZiStroke(int size){
        paint.setStrokeWidth(size);
        invalidate();
    }

    public void setGeZiWidth(int geZiWidth){
        this.geZiWidth = geZiWidth;
        invalidate();
    }

    public void setGeZiBg(int bgColor){
        this.bgColor = bgColor;
        bgPaint.setColor(bgColor);
        invalidate();
    }

    public void setGeZiCount(int geZiCount){
        this.geZiCount = geZiCount;
    }

    private void initView() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(getResources().getColor(R.color.geziColor));
        paint.setStrokeWidth(1);


        fillPaint = new Paint();
        fillPaint.setAntiAlias(true);
        fillPaint.setStyle(Paint.Style.FILL);
        fillPaint.setColor(Color.BLACK);

        bgPaint = new Paint();
        bgPaint.setAntiAlias(true);
        bgPaint.setColor(bgColor);
        bgPaint.setStyle(Paint.Style.FILL);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mWidth = getSize(widthMeasureSpec, defaultSize);

        widthCount = mWidth / geZiWidth;

        Log.e("tag","widthCount:"+ widthCount);

        //行数
        line = geZiCount / widthCount;

        Log.e("tag","line:"+ line);
        //余格
        remaineGezi = geZiCount % widthCount;

        Log.e("tag","remaineGezi:"+remaineGezi);

        //控件高度
        for (int i = 0; i<= line +1 ; i++){
            mHeight = i * geZiWidth;
        }

        setMeasuredDimension(mWidth, mHeight);

    }

    public int getSize(int measureSpace,int defaultSize){
        int mode = MeasureSpec.getMode(measureSpace);
        int size = defaultSize;
        switch (mode){
            case MeasureSpec.UNSPECIFIED:
                size = defaultSize;
                break;
            case MeasureSpec.AT_MOST:
                size = MeasureSpec.getSize(measureSpace);
                break;
            case MeasureSpec.EXACTLY:
                size = MeasureSpec.getSize(measureSpace);
                break;
            default:
        }
        return size;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int nextY = 0;
        int nextX = 0;
        int heightCount = mHeight / geZiWidth - 1;
        Log.e("tag","heightCount:"+heightCount);
        //画背景色
        if (heightCount > 0) {
            canvas.drawRect(0, 0, widthCount * geZiWidth, heightCount * geZiWidth, bgPaint);
            if (remaineGezi != 0) {
                canvas.drawRect(0, heightCount * geZiWidth, remaineGezi * geZiWidth, (heightCount + 1) * geZiWidth, bgPaint);
            }
        }else{
            canvas.drawRect(0, 0, remaineGezi * geZiWidth,  geZiWidth, bgPaint);
        }

        //计算完整的行数
        int fillLine = fillCount / widthCount;
        Log.e("tag","fillLine:"+fillLine);
        //不足完整一行的格子数
        int cs = fillCount % widthCount;
        Log.e("tag","cs:"+cs);
        if (fillLine > 0) {
            //画填充背景
            canvas.drawRect(0, 0, widthCount * geZiWidth, fillLine * geZiWidth, fillPaint);
            if (cs != 0) {
                canvas.drawRect(0, fillLine * geZiWidth, (cs) * geZiWidth,
                        (fillLine + 1) * geZiWidth, fillPaint);
            }
        }else{
            canvas.drawRect(0, 0, cs * geZiWidth, geZiWidth, fillPaint);
        }

        //行
        for (int i = 0 ; i<=heightCount + 1; i++){
            if (heightCount == 0) {
                canvas.drawLine(0, nextY, remaineGezi * geZiWidth, nextY, paint);
            }else {
                if (i == heightCount + 1) {
                    canvas.drawLine(0, nextY, remaineGezi * geZiWidth, nextY, paint);
                    break;
                }
                canvas.drawLine(0, nextY, widthCount * geZiWidth, nextY, paint);
            }
            nextY += geZiWidth;
        }

        //列
        for (int i = 0 ; i<=widthCount; i++){
            if (i<= remaineGezi){
                canvas.drawLine(nextX,0,nextX,(heightCount + 1) * geZiWidth,paint);
            }else {
                canvas.drawLine(nextX, 0, nextX, heightCount * geZiWidth, paint);
            }
            nextX += geZiWidth;
        }

    }

    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
