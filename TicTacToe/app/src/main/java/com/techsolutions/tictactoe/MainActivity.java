package com.techsolutions.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    // 0 = circle, 1 = cross
    int activePlayer = 0;

    int gameState[] = {2,2,2,2,2,2,2,2,2};

    int winningPositions[][] = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
    };

    boolean gameIsActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view){
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tappedCounter] == 2 && gameIsActive){

            gameState[tappedCounter] = activePlayer;
            counter.setTranslationY(-1000f);

            if (activePlayer == 0){
                counter.setImageResource(R.drawable.circle);
                activePlayer = 1;
            }else {
                counter.setImageResource(R.drawable.cross);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1000f).setDuration(300);

            for (int[] winningPosition : winningPositions){
                if (gameState[winningPosition[0]]==gameState[winningPosition[1]] &&
                        gameState[winningPosition[2]]==gameState[winningPosition[1]] &&
                        gameState[winningPosition[0]]!=2){
                    gameIsActive = false;
                    String player = "Player 1";
                    if (gameState[winningPosition[0]]==1)
                        player="Player 2";
                    TextView textView = (TextView)findViewById(R.id.playAgainMessage);
                    textView.setText("congrats"+ player +" has won!");
                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);
                }else{
                    boolean gameIsOver = true;
                    for (int counterState : gameState){
                        if (counterState == 2)
                            gameIsOver = false;
                    }
                    if (gameIsOver){
                        TextView textView = (TextView)findViewById(R.id.playAgainMessage);
                        textView.setText("It's a draw");
                        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                        layout.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }

    public  void playAgain(View view){
        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);

        activePlayer = 0;
        gameIsActive = true;

        for (int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        GridLayout gridLayout = findViewById(R.id.gridLayout);
        for (int i=0;i<9;i++){
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
        }
    }
}
