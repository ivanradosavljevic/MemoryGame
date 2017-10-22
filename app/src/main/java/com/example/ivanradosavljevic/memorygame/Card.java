package com.example.ivanradosavljevic.memorygame;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by Ivan Radosavljevic on 21.10.2017.
 */

public class Card {
    private Bitmap bitmap;
    private int id;
    boolean isBack;

    public Card(Bitmap bitmap, int id) {
        this.bitmap = bitmap;
        this.id = id;
        isBack = false;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
    public Bitmap getBitmap() {
        return bitmap;
    }
    public boolean isBack() {
        return isBack;
    }
    public void setBack(boolean back) {
        isBack = back;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
