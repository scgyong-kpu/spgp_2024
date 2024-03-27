package kr.ac.tukorea.ge.spgp2024.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class GameView extends View {
    private static final String TAG = GameView.class.getSimpleName();
    private TextPaint mTextPaint;

    // Lazy Initialization
    private Paint paint;
    private Rect rect;
    private Paint getPaint() {
        if (paint == null) {
            paint = new Paint();
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(0.01f);
        }
        return paint;
    }

    public GameView(Context context) {
        super(context);
        init(null, 0);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int l = getPaddingLeft(), r = getPaddingRight();
        int t = getPaddingTop(), b = getPaddingBottom();
        int w = getWidth(), h = getHeight();
        int contentWidth = (w - l - r);
        int contentHeight = (h - t - b);
        int offsetX = 0, offsetY = 0, size;
        if (contentWidth > contentHeight) {
            offsetX = (contentWidth - contentHeight) / 2;
            size = contentHeight;
        } else {
            offsetY = (contentHeight - contentWidth) / 2;
            size = contentWidth;
        }
        Log.d(TAG, "l="+l+" t="+t+" cw=" + contentWidth + " ch=" + contentHeight);
        Log.d(TAG, "offsetX="+offsetX+" offsetY="+offsetY+" size="+size);
        drawSmiley(canvas, l + offsetX, t + offsetY, size, 3);
    }

    private void drawSmiley(Canvas canvas, float tx, float ty, float scale, int depth) {
        canvas.save();
        canvas.translate(tx, ty);
        canvas.scale(scale, scale);

        canvas.drawCircle(0.5f, 0.5f, 0.5f, getPaint());

        float leftEyeX = 1.0f/3.0f, rightEyeX = 2.0f/3.0f;
        float eyeY = 3.0f / 8.0f;
        float eyeRadius = 1.0f / 8.0f;

        Log.d(TAG, "Depth = " + depth);
        if (depth > 0) {
            drawSmiley(canvas, leftEyeX - eyeRadius, eyeY - eyeRadius, 2 * eyeRadius, depth - 1);
            drawSmiley(canvas, rightEyeX - eyeRadius, eyeY - eyeRadius, 2 * eyeRadius, depth - 1);
        } else {
            canvas.drawCircle(leftEyeX, eyeY, eyeRadius, paint);
            canvas.drawCircle(rightEyeX, eyeY, eyeRadius, paint);
        }

        float mouthX1 = 0.25f, mouthX2 = 0.75f;
        float mouthY = 0.75f;
        canvas.drawArc(mouthX1, eyeY, mouthX2, mouthY, 15, 150, false, paint);
        canvas.restore();
    }
}