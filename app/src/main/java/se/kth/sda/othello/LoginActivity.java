package se.kth.sda.othello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

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


    // Method for going to second activity which is delayed by 3 seconds.
    // By Armin Dizdar 05/12/2017

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
    }

    @Override
    public void onBackPressed () {
        super.onBackPressed();

    }

}
