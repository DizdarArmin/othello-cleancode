package se.kth.sda.othello;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import se.kth.sda.othello.board.Board;
import se.kth.sda.othello.board.Node;

/**
 * Created by robertog on 2/7/17.
 */

public class BoardView extends View {
    private Board model;
    Bitmap dark = BitmapFactory.decodeResource(getResources(),R.mipmap.dark);
    Bitmap light  = BitmapFactory.decodeResource(getResources(),R.mipmap.light);


    public void setModel(Board model) {
        this.model = model;
    }

    public interface BoardViewListener {
        public void onClick(int x, int y);
    }

    private final GestureDetector mDetector;
    private BoardViewListener eventListener = null;

    class mListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
    }

    public BoardView(Context context) {
        super(context);

        mDetector = new GestureDetector(this.getContext(), new mListener());
    }
    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mDetector = new GestureDetector(this.getContext(), new mListener());
    }

    public void setEventListener(BoardViewListener listener) {
        this.eventListener = listener;
    }

    @Override
    protected void onDraw(Canvas canvas) {


        // Modified method to draw image instead of paint.
        // By Armin Dizdar 05/12/2017
        int height = getHeight();
        int width = getWidth();

        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                if ((i+j)%2 == 0)
                    canvas.drawBitmap(dark, width/8*i, height/8*j, null);
                else
                   canvas.drawBitmap(light, width/8*i, height/8*j, null);
            }
        }


        /*
        Resources res = getResources();
        Drawable draw = res.getDrawable(R.drawable.kth);
        draw.setBounds(width/8*xpos, height/8*ypos, width/8*(xpos+1), height/8*(ypos+1));
        draw.draw(canvas);
        */

        if (model == null)
            return;

        Paint whitePaint = new Paint();
        whitePaint.setARGB(255, 255, 255, 255);
        Paint blackPaint = new Paint();
        blackPaint.setARGB(255, 0, 0, 0);


        for (Node node : model.getNodes()) {
            if (node.isMarked()) {
                Paint color = node.getOccupantPlayerId().equals("P1") ? whitePaint : blackPaint;
                canvas.drawCircle(
                        (float)(width/8*(node.getXCoordinate()+0.5)),
                        (float)(height/8*(node.getYCoordinate()+0.5)),
                        (float)(Math.min(width/16,height/16)),
                        color);
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (eventListener == null)
            return true;

        boolean result = mDetector.onTouchEvent(event);
        if (!result) {

            if (event.getAction() == MotionEvent.ACTION_UP) {
                eventListener.onClick((int)(event.getX()/this.getWidth()*8), (int)(event.getY()/this.getHeight()*8));

                result = true;
            }
        }
        return result;
    }
}