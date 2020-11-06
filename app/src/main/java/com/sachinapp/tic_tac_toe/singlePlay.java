package com.sachinapp.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.ArrayList;

public class singlePlay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_play);

        Intent intent = getIntent();
    }

    //GameState: for human
    //  0 - x
    // 1 - o

    boolean play = true;

    boolean win = false;

    int human = 0;
    int computer = 1;
    int imageTagComputer;

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
    ArrayList<Integer> computerState = new ArrayList<Integer>(){{
        add(0);
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        add(7);
        add(8);
    }};

    int[][] winPos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};

    public void onTap(View view)
    {
        ImageView img = (ImageView) view;
        ImageView imgcomp = (ImageView) view;

        //Human's Choice
        int imageTagHuman = Integer.parseInt(img.getTag().toString());
        computerState.remove(new Integer(imageTagHuman));


        //Generating random number for computer move
        try {
            Random random = new Random();
            int rand = random.nextInt(computerState.size());

            imageTagComputer = computerState.get(rand);
            computerState.remove(new Integer(imageTagComputer));
        }catch (Exception ex){
            imageTagComputer = 9;
        }

        //Resetting game
        if(!play)
        {
            gameReset(view);
        }
        else if(gameState[imageTagHuman] == 2 && gameState[imageTagComputer] == 2)
        {
            gameState[imageTagHuman] = human;
            gameState[imageTagComputer] = computer;

            img.setTranslationY(-1000f);
            imgcomp.setTranslationY(-1000f);

            //For Humnan Move

            img.setImageResource(R.drawable.x);
            TextView status = findViewById(R.id.turn);
            status.setText("O's turn- tap to play");

                //For COMPUTER move;
            if(imageTagComputer==0)
            {
                ((ImageView)findViewById(R.id.image0)).setImageResource(R.drawable.o);
            }
            if(imageTagComputer==1)
            {
                ((ImageView)findViewById(R.id.imageView1)).setImageResource(R.drawable.o);
            }
            if(imageTagComputer==2)
            {
                ((ImageView)findViewById(R.id.imageView2)).setImageResource(R.drawable.o);
            }
            if(imageTagComputer==3)
            {
                ((ImageView)findViewById(R.id.imageView3)).setImageResource(R.drawable.o);
            }
            if(imageTagComputer==4)
            {
                ((ImageView)findViewById(R.id.imageView4)).setImageResource(R.drawable.o);
            }
            if(imageTagComputer==5)
            {
                ((ImageView)findViewById(R.id.imageView5)).setImageResource(R.drawable.o);
            }
            if(imageTagComputer==6)
            {
                ((ImageView)findViewById(R.id.imageView6)).setImageResource(R.drawable.o);
            }
            if(imageTagComputer==7)
            {
                ((ImageView)findViewById(R.id.imageView7)).setImageResource(R.drawable.o);
            }
            if(imageTagComputer==8)
            {
                ((ImageView)findViewById(R.id.imageView8)).setImageResource(R.drawable.o);
            }
            TextView status1 = findViewById(R.id.turn);
            status1.setText("X's turn- tap to play");

            img.animate().translationYBy(1000f).setDuration(300);
            imgcomp.animate().translationYBy(1000f).setDuration(300);
        }

        gameOver();

    }


    public void gameReset(View view)
    {
        play = true;

        human = 0;
        computer = 1;

        for(int j=0; j<gameState.length; j++)
        {
            gameState[j] = 2;
        }

        for(int i = 0; i<9; i++)
        {
            computerState.add(i, i);
        }

        TextView status = findViewById(R.id.turn);
        status.setText("Your turn - tap to play");

        ((ImageView)findViewById(R.id.image0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
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

    public void gameOver()
    {
        for (int[] checkList : winPos)
        {
            if (gameState[checkList[0]] == gameState[checkList[1]] && gameState[checkList[1]] == gameState[checkList[2]] && gameState[checkList[0]]!=2)
            {
                if(gameState[checkList[0]] == human)
                {
                    TextView status = findViewById(R.id.turn);
                    status.setText("You won");
                    play = false;
                    //gameReset(view);
                }
                else
                {
                    TextView status = findViewById(R.id.turn);
                    status.setText("You loss");
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
}