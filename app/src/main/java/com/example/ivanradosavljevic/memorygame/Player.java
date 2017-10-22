package com.example.ivanradosavljevic.memorygame;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Ivan Radosavljevic on 22.10.2017.
 */

public class Player implements Parcelable, Comparable {

    String name;
    int numberOfPoints;
    public static ArrayList<Player> playerList = new ArrayList<>();

    protected Player(Parcel in) {
        name = in.readString();
        numberOfPoints = in.readInt();
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            Log.d("creating", "creating player from parsel");
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(String name, int numberOfPoints) {
        this.name = name;
        this.numberOfPoints = numberOfPoints;
    }

    public Player() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
       // dest.writeArray(playerList.toArray());
//        dest.writeTypedList(playerList);
        dest.writeString(name);
        dest.writeInt(numberOfPoints);
    }

    @Override
    public int compareTo(@NonNull Object o) {
        int compareage=((Player)o).getNumberOfPoints();

        return compareage-this.getNumberOfPoints();
    }
}
