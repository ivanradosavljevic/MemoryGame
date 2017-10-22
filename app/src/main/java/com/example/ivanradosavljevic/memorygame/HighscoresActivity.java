package com.example.ivanradosavljevic.memorygame;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighscoresActivity extends AppCompatActivity {

    TextView firstPlace;
    TextView secondPlace;
    TextView thirdPlace;
    TextView fourthPlace;
    TextView fifthPlace;
    ArrayList<Player> players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscores);
       // players = Player.playerList;
        firstPlace = (TextView) findViewById(R.id.first_place);
        secondPlace = (TextView) findViewById(R.id.second_place);
        thirdPlace = (TextView) findViewById(R.id.third_place);
        fourthPlace = (TextView) findViewById(R.id.fourth_place);
        fifthPlace = (TextView) findViewById(R.id.fifth_place);
        SharedPreferences sharedPreferences = getSharedPreferences("Y", MODE_PRIVATE);
        Gson gson = new Gson();
        String gsonString = sharedPreferences.getString("gsonPlayers", "");
            Type typeList = new TypeToken<List<Player>>(){}.getType();
            players = gson.fromJson(gsonString,typeList);

        //highest score first
        Collections.sort(players);
        int size = players.size();

        switch (size) {
            case 0:
                firstPlace.setText("Score list is empty");
                break;

            case 1:
                firstPlace.setText(players.get(0).getName() + " , number of points: " + players.get(0).getNumberOfPoints());
                break;
            case 2:
                firstPlace.setText(players.get(0).getName() + " , number of points: " + players.get(0).getNumberOfPoints());
                secondPlace.setText(players.get(1).getName() + " , number of points: " + players.get(1).getNumberOfPoints());
                break;
            case 3:
                firstPlace.setText(players.get(0).getName() + " , number of points: " + players.get(0).getNumberOfPoints());
                secondPlace.setText(players.get(1).getName() + " , number of points: " + players.get(1).getNumberOfPoints());
                thirdPlace.setText(players.get(2).getName() + " , number of points: " + players.get(2).getNumberOfPoints());
                break;
            case 4:
                firstPlace.setText(players.get(0).getName() + " , number of points: " + players.get(0).getNumberOfPoints());
                secondPlace.setText(players.get(1).getName() + " , number of points: " + players.get(1).getNumberOfPoints());
                thirdPlace.setText(players.get(2).getName() + " , number of points: " + players.get(2).getNumberOfPoints());
                fourthPlace.setText(players.get(3).getName() + " , number of points: " + players.get(3).getNumberOfPoints());
                break;
            case 5:
                firstPlace.setText(players.get(0).getName() + " , number of points: " + players.get(0).getNumberOfPoints());
                secondPlace.setText(players.get(1).getName() + " , number of points: " + players.get(1).getNumberOfPoints());
                thirdPlace.setText(players.get(2).getName() + " , number of points: " + players.get(2).getNumberOfPoints());
                fourthPlace.setText(players.get(3).getName() + " , number of points: " + players.get(3).getNumberOfPoints());
                fifthPlace.setText(players.get(4).getName() + " , number of points: " + players.get(4).getNumberOfPoints());
                break;
            default:
                firstPlace.setText(players.get(0).getName() + " , number of points: " + players.get(0).getNumberOfPoints());
                secondPlace.setText(players.get(1).getName() + " , number of points: " + players.get(1).getNumberOfPoints());
                thirdPlace.setText(players.get(2).getName() + " , number of points: " + players.get(2).getNumberOfPoints());
                fourthPlace.setText(players.get(3).getName() + " , number of points: " + players.get(3).getNumberOfPoints());
                fifthPlace.setText(players.get(4).getName() + " , number of points: " + players.get(4).getNumberOfPoints());
        }
    }
}
