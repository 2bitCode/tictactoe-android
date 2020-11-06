package com.sachinapp.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class doublePlay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_play);

        getIntent();
    }

    //GameState:
    //  0 - x
    // 1 - o

    boolean play = true;

    boolean win = false;

    int activePlayer = 0;

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winPos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};

    public void onTap(View view) {

        ImageView img = (ImageView) view;
        int imageTag = Integer.parseInt(img.getTag().toString());

        if(!play)
        {
            gameReset(view);
        }
        else if (gameState[imageTag] == 2) {

            gameState[imageTag] = activePlayer;
            img.setTranslationY(-1000f);

            if (activePlayer == 0) {

                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.turn);
                status.setText("O's turn now - tap to play");
            } else {

                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.turn);
                status.setText("X's turn now - tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        for (int[] checkList : winPos)
        {
            if (gameState[checkList[0]] == gameState[checkList[1]] && gameState[checkList[1]] == gameState[checkList[2]] && gameState[checkList[0]]!=2)
            {
                if(gameState[checkList[0]] == 1)
                {
                    TextView status = findViewById(R.id.turn);
                    status.setText("O is winner");
                    play = false;
                    //gameReset(view);
                }
                else
                {
                    TextView status = findViewById(R.id.turn);
                    status.setText("X is winner");
                    play = false;
                    //gameReset(view);
                }
                win = true;
            }

        }

        if(!checkArray(gameState) && !win)
        {
            TextView status = findViewById(R.id.turn);
            status.setText("Match Draw");
            play = false;
        }

    }


    public void gameReset(View view) {
        play = true;

        activePlayer = 0;

        for (int j = 0; j < gameState.length; j++) {
            gameState[j] = 2;
        }

        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.turn);
        status.setText("X's turn - tap to play");
    }


    public boolean checkArray(int[] array1)
    {

        boolean test = false;

        for(int element : array1)
        {
            if(element==2)
            {
                test = true;
            }
        }

        return test;
    }
}