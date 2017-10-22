package com.example.ivanradosavljevic.memorygame;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by Ivan Radosavljevic on 21.10.2017.
 */

public class Card {
    private Bitmap bitmap;
    private int id;

    public Card(Bitmap bitmap, int id) {
        this.bitmap = bitmap;
        this.id = id;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmapl(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
