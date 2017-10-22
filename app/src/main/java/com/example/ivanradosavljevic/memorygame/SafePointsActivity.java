package com.example.ivanradosavljevic.memorygame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

public class SafePointsActivity extends AppCompatActivity {

    TextView tvNumberOfPoints;
    EditText etName;
    Button save;
    int points = 0;
    boolean isClosing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe_points);
        etName = (EditText) findViewById(R.id.editTextName);
        save = (Button) findViewById(R.id.btnSave);
        points = getIntent().getIntExtra("points",0);
        isClosing = getIntent().getBooleanExtra("isClosing",false);
    }

    public void clickedSave(View view) {
        String name = etName.getText().toString();
        Player.playerList.add(new Player(name,points));
        if(isClosing)
        {
            Intent intent = new Intent(SafePointsActivity.this,MainActivity.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(SafePointsActivity.this,GameActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getSharedPreferences("Y", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String gsonPlayer = gson.toJson(Player.playerList);
        editor.putString("gsonPlayers", gsonPlayer);
        editor.commit();
    }
}
