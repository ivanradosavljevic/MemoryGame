package com.example.ivanradosavljevic.memorygame;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SafePointsActivity extends AppCompatActivity {

    TextView tvNumberOfPoints;
    EditText etName;
    Button save;
    int points = 0;
    boolean isClosing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState != null)
        {
            Player.playerList = savedInstanceState.getParcelable("highscore");
        }
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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("highscore", Player.playerList);
    }
}
