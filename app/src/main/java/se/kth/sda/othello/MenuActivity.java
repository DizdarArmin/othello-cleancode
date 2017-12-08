package se.kth.sda.othello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    /** Called when the user clicks the Create Human vs Human button */
    public void startHumanGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.GAME_TYPE, MainActivity.GAME_HUMAN);
        startActivityForResult(intent, 0);
    }

    //start: created by Aleksandar 12.08
    /** Called when the user clicks the Create Human vs Computer button */
    public void startHumanVsComputerGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.GAME_TYPE, MainActivity.GAME_COMPUTER);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Toast t = Toast.makeText(this, data.getExtras().getString(MainActivity.GAME_RESULT), Toast.LENGTH_SHORT);
        t.show();
    }



    //Exit from game method.
    // By Armin Dizdar
    public void exitGame(View view){
        finishAffinity();
    }

    // On back button pressed from MenuActivity will go to LoginActivity.
    // By Armin Dizdar.
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
        startActivityForResult(intent, 0);
    }
}
