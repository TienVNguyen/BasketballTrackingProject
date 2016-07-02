/*
 * Copyright (c) 2016. Self Training Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by TienNguyen <tien.workinfo@gmail.com - tien.workinfo@icloud.com>, October 2015
 */

package com.training.tiennguyen.basketballtracking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * MainActivity
 *
 * @author TienNguyen
 */
public class MainActivity extends AppCompatActivity {
    @Bind(R.id.teamA_name)
    protected TextView teamAName;
    @Bind(R.id.teamB_name)
    protected TextView teamBName;
    @Bind(R.id.teamA_score)
    protected TextView teamAScore;
    @Bind(R.id.teamB_score)
    protected TextView teamBScore;

    @Bind(R.id.teamA_plus_one)
    protected Button teamAPlusOne;
    @Bind(R.id.teamA_plus_two)
    protected Button teamAPlusTwo;
    @Bind(R.id.teamA_plus_three)
    protected Button teamAPlusThree;
    @Bind(R.id.teamB_plus_one)
    protected Button teamBPlusOne;
    @Bind(R.id.teamB_plus_two)
    protected Button teamBPlusTwo;
    @Bind(R.id.teamB_plus_three)
    protected Button teamBPlusThree;

    @Bind(R.id.reset)
    protected Button reset;
    @Bind(R.id.result)
    protected TextView result;

    /**
     * This action will be executed when activity is called
     *
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    /**
     * Initial view(s) inside of main activity
     */
    private void initView() {
        ButterKnife.bind(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamAScore.setText("0");
                teamBScore.setText("0");
                resultFunction();
                Toast.makeText(MainActivity.this, "Clear the game!", Toast.LENGTH_SHORT).show();
            }
        });

        teamAPlusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamPlusFunction("A", 1);
                resultFunction();
            }
        });

        teamAPlusTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamPlusFunction("A", 2);
                resultFunction();
            }
        });

        teamAPlusThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamPlusFunction("A", 3);
                resultFunction();
            }
        });

        teamBPlusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamPlusFunction("B", 1);
                resultFunction();
            }
        });

        teamBPlusTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamPlusFunction("B", 2);
                resultFunction();
            }
        });

        teamBPlusThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamPlusFunction("B", 3);
                resultFunction();
            }
        });

        resultFunction();
    }

    /**
     * Decide the current result
     */
    private void resultFunction() {
        int teamACurrentScore = Integer.parseInt(teamAScore.getText().toString());
        int teamBCurrentScore = Integer.parseInt(teamBScore.getText().toString());

        String replacement;
        if (teamACurrentScore == teamBCurrentScore) {
            replacement = "0 ::: 0";
        } else if (teamACurrentScore > teamBCurrentScore) {
            replacement = "Team " + teamAName.getText().toString() + " is ahead";
        } else {
            replacement = "Team " + teamBName.getText().toString() + " is ahead";
        }
        result.setText(replacement);
    }

    /**
     * Plus Function
     *
     * @param type TeamA or teamB
     * @param i    number vary from 1 to 3
     */
    private void teamPlusFunction(String type, int i) {
        int score;
        if (type.equalsIgnoreCase("A")) {
            score = Integer.parseInt(teamAScore.getText().toString());

            switch (i) {
                case 1:
                    teamAScore.setText(String.valueOf(score + 1));
                    break;
                case 2:
                    teamAScore.setText(String.valueOf(score + 2));
                    break;
                case 3:
                    teamAScore.setText(String.valueOf(score + 3));
                    break;
                default:
                    break;
            }
        } else if (type.equalsIgnoreCase("B")) {
            score = Integer.parseInt(teamBScore.getText().toString());

            switch (i) {
                case 1:
                    teamBScore.setText(String.valueOf(score + 1));
                    break;
                case 2:
                    teamBScore.setText(String.valueOf(score + 2));
                    break;
                case 3:
                    teamBScore.setText(String.valueOf(score + 3));
                    break;
                default:
                    break;
            }
        }
    }
}
