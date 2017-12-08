package se.kth.sda.othello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import se.kth.sda.othello.imp.OthelloFactoryImp;

public class LoginActivity extends Activity {
    public static final String GAME_TYPE = "GAME_TYPE";
    public static final String GAME_HUMAN = "HUMAN";
    public static final String GAME_RESULT = "GAME_RESULT";

    OthelloFactory gameFactory = new OthelloFactoryImp();
    Othello game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        begin();
    }

    /**
     * Multithreading
     * Going to second activity which is delayed by 3 seconds.
     * Calling rotate method.
     * @author Armin Dizdar
     */
    public void begin() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                rotate();
            }
        }).start();


    }

    /** Rotating logo image by 360 degrees in 3 seconds.
     * @author Armin Dizdar
     */
    public void rotate(){
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(3000);
        ImageView logo = (ImageView) findViewById(R.id.logo_image);
        logo.startAnimation(rotate);
    }

    @Override
    public void onBackPressed () {
        super.onBackPressed();

    }

}
