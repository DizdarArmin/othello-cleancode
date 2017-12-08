package se.kth.sda.othello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import se.kth.sda.othello.imp.NodeImp;
import se.kth.sda.othello.imp.OthelloFactoryImp;
import se.kth.sda.othello.player.Player;

public class MainActivity extends Activity {
    public static final String GAME_TYPE = "GAME_TYPE";
    public static final String GAME_HUMAN = "HUMAN";
    public static final String GAME_RESULT = "GAME_RESULT";
    public static final String GAME_PLAYERONE = "P1";
    public static final String GAME_PLAYERTWO = "P2";

    OthelloFactory gameFactory = new OthelloFactoryImp();
    Othello game;
    //start: modify by Xin 11.23
    private ImageView turnImage;
    private TextView totalPlayerOne;
    private TextView totalPlayerTwo;
    //end
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BoardView boardView = (BoardView) findViewById(R.id.boardView);
        //start: modify by Xin 11.23
        turnImage = (ImageView) findViewById(R.id.turn_image);
        totalPlayerOne =(TextView) findViewById(R.id.total_playerOne);
        totalPlayerTwo =(TextView) findViewById(R.id.total_playerTwo);
        //end
        if (this.getIntent().getExtras().getString(GAME_TYPE).equals(GAME_HUMAN)) {
            game = gameFactory.createHumanGame();
        }

        game.start();

        boardView.setModel(game.getBoard());
        game.moveInitialNodes();                 // add initial coins on the board
        boardView.setEventListener(new BoardView.BoardViewListener() {
            @Override
            public void onClick(int x, int y) {
                String nodeId = NodeImp.format(x, y);
                Player currentPlay = game.getPlayerInTurn();
                try {
                    if (game.isActive()) { // check there are valid moves
                        if (game.hasValidMove(currentPlay.getId())) {
                            game.move(currentPlay.getId(), nodeId);
                            swapPlayerTurnImage(currentPlay);

                            currentPlay = game.getPlayerInTurn();

                            // swap player automatically if they have no valid moves
                            if (!game.hasValidMove(currentPlay.getId())) {
                                swapPlayerAutomatically(currentPlay);
                            }
                        }
                        else { // swap player automatically if they have no valid moves
                            swapPlayerAutomatically(currentPlay);
                            currentPlay = game.getPlayerInTurn();

                            // swap player automatically if they have no valid moves
                            if (!game.hasValidMove(currentPlay.getId())) {
                                swapPlayerAutomatically(currentPlay);
                            }
                        }
                    }
                    else {
                        displayEndMessage(game.getGameEndMessage());
                        return;
                    }
                } catch (IllegalStateException e) {
                    if (e.getMessage().equals("Invalid move")) {
                        displayToast(e.getMessage());
                        return;
                    }
                }

                totalPlayerOne.setText(String.valueOf(game.getPlayerScore(GAME_PLAYERONE)));
                totalPlayerTwo.setText(String.valueOf(game.getPlayerScore(GAME_PLAYERTWO)));

                //end
                boardView.invalidate();

                if (!game.isActive()) {
                    displayEndMessage(game.getGameEndMessage());
                    swapPlayerTurnImage(currentPlay);
                    return;
                }

            }
        });
    }

    private void displayEndMessage(String message){
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View popUp = inflater.inflate(R.layout.pop_up_layout, null);
        dialogBuilder.setView(popUp);
        final AlertDialog alertDialog = dialogBuilder.create();

        TextView text =(TextView) popUp.findViewById(R.id.end_message);
        Button menu = (Button) popUp.findViewById(R.id.menu_button);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.cancel();
                quitGame(view);
            }
        });
        text.setText(message);
        alertDialog.show();


        }


    // Customized toast method which displays rectangle toast with white background and black text.
    // @param message
    // By Armin Dizdar
    private void displayToast(String message){
        Toast toast = new Toast(MainActivity.this);
        toast.setDuration(Toast.LENGTH_SHORT);
        LayoutInflater li = getLayoutInflater();
        View toastAppear = li.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_linear));
        toast.setView(toastAppear);
        TextView toastToDisplay = (TextView) toastAppear.findViewById(R.id.toastToDisplay);
        toastToDisplay.setText(message);
        toast.show();

    }

    private void swapPlayerTurnImage(Player currentPlay){
        if (GAME_PLAYERONE.equals(currentPlay.getId())) {
            turnImage.setImageResource(R.mipmap.ic_arrow_right);
        } else if (GAME_PLAYERTWO.equals(currentPlay.getId())) {
            turnImage.setImageResource(R.mipmap.ic_arrow_left);
        }
    }
    public void quitGame(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra (GAME_RESULT, "Back to the menu");
        setResult(RESULT_OK, intent);
        super.finish();
 		
    }
    // On back button pressed from MainActivity will go to MenuActivity.
    // By Armin Dizdar.
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getBaseContext(), MenuActivity.class);
        startActivityForResult(intent, 0);
    }

    /**
     * Swap a player automatically and display a corresponding message.
     * Only if there are unoccupied nodes on the board.
     * @param currentPlayer the player in turn
     * @author petrych
     */
    public void swapPlayerAutomatically(Player currentPlayer) {
        if (game.isActive()) {
            displayToast("Current player has no moves. Switched to another player");
            game.swapPlayer();
            swapPlayerTurnImage(currentPlayer);
        }
    }
}
