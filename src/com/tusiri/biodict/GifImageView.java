package com.tusiri.biodict;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import com.tusiri.biodict.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.ImageView;

public class GifImageView extends ImageView {

    Movie movie;
    InputStream inputStream;
    private long mMovieStart;
    String filename;
    
    public GifImageView(Context context, AttributeSet attrs, int defStyleAttr, String filename) {
        super(context, attrs, defStyleAttr);
        this.filename=filename;
    }

    public GifImageView(Context context) {
        super(context);
    }

    public GifImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        inputStream = context.getResources()
                .openRawResource(R.drawable.splash_busri);
            byte[] array = streamToBytes(inputStream);
            movie = Movie.decodeByteArray(array, 0, array.length);

    }

    private byte[] streamToBytes(InputStream is) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(
                1024);
        byte[] buffer = new byte[1024];
        int len;
        try {
            while ((len = is.read(buffer)) >= 0) {
                byteArrayOutputStream.write(buffer, 0, len);
                return byteArrayOutputStream.toByteArray();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        long now = SystemClock.uptimeMillis();
        if (mMovieStart == 0) { // first time
            mMovieStart = now;
        }
        if (movie != null) {
            int dur = movie.duration();
            if (dur == 0) {
                dur = 3000;
            }
            int relTime = (int) ((now - mMovieStart) % dur);
            movie.setTime(relTime);
            movie.draw(canvas, getWidth() - 200, getHeight() - 200);
            invalidate();
        }
    }

}