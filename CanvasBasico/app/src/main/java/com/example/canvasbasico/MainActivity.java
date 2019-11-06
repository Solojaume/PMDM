package com.example.canvasbasico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Dibujo(this));

    }
    class Dibujo extends View{

        public Dibujo(Context context) {
            super(context);

        }

        @Override
//        protected void onDraw(Canvas canvas) {
//            int height=getHeight()/2;
//            int width= getWidth()/2;
//            Paint pincel = new Paint();
//            pincel.setColor(Color.RED);
//            pincel.setStrokeWidth(15);
//            pincel.setStyle(Paint.Style.FILL);
//            canvas.drawCircle(width,height-75,80, pincel);
//        }
        protected  void onDraw(Canvas canvas){
            int height=getHeight()/2;
            int width= getWidth()/2;
            Paint pincel = new Paint();
            pincel.setColor(Color.MAGENTA);
            pincel.setStrokeWidth(15);
            pincel.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(width,height,230, pincel);
            pincel.setColor(Color.CYAN);
            canvas.drawRect(width, height, width,height ,pincel);
            pincel.setColor(Color.RED);
            pincel.setStrokeWidth(80);
            canvas.drawRect(width-450, 100, width-450,100 ,pincel);
            pincel.setColor(Color.BLUE);
            canvas.drawRect(width+450, 100, width+450, 100,pincel);
            pincel.setColor(Color.GREEN);
            canvas.drawRect(width-450, 1500, width-450, 1500,pincel);
            pincel.setColor(Color.YELLOW);
            canvas.drawRect(width+450, 1500, width+450, 1500,pincel);

        }
    }
}
