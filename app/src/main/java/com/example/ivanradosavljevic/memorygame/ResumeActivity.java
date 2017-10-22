package com.example.ivanradosavljevic.memorygame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ResumeActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    boolean reloadPrevious = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        sharedPreferences = getSharedPreferences("X", MODE_PRIVATE);
        Gson gson = new Gson();
        reloadPrevious = sharedPreferences.getBoolean("reloadPrevious", false);
        if (!reloadPrevious) {
            Toast.makeText(getApplicationContext(), "No saved game.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ResumeActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(ResumeActivity.this, GameActivity.class);
            startActivity(intent);
        }
    }
}
