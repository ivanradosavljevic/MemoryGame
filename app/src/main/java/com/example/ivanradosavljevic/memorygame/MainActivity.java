package com.example.ivanradosavljevic.memorygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickedNewGame(View v)
    {
        Intent intent = new Intent(MainActivity.this,GameActivity.class);
        startActivity(intent);
    }
    public void clickedResumeGame(View v)
    {
        //Toast.makeText(this, "to be", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,ResumeActivity.class);
        startActivity(intent);
    }
    public void clickedHighscores(View v){
        Intent intent = new Intent(MainActivity.this,HighscoresActivity.class);
        startActivity(intent);
    }
}
