package se.kth.sda.othello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
    }

    public void login(View view) {
        EditText inputLogin = (EditText) findViewById(R.id.edit_login);
        String login = inputLogin.getText().toString();
        EditText inputPwd = (EditText) findViewById(R.id.edit_pwd);
        String pwd = inputPwd.getText().toString();

        Intent intent = new Intent(getBaseContext(), MenuActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
