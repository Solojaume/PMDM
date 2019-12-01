package com.example.ejerciciorepaso1trimestre;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;


public class Logo extends View {


    public Logo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Logo(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.dibujo);
        canvas.drawBitmap(b, 50, 50, null);
    }
}

