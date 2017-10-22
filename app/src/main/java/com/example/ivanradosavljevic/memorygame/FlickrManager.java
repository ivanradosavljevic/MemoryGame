package com.example.ivanradosavljevic.memorygame;

/**
 * Created by Ivan Radosavljevic on 21.10.2017.
 */

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.util.Log;

//import com.example.flickr_michalueu_example.GameActivity.UIHandler;

public class FlickrManager {

    public static ArrayList<String> listOfURLs = new ArrayList<>();

    public static void GenerateList(String json) {
        String jResult = null;
        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONObject json_photos = jsonObject.getJSONObject("photos");
            JSONArray jsonArray_photo = json_photos.getJSONArray("photo");
            for (int i = 0; i < jsonArray_photo.length(); i++) {
                JSONObject flickrPhoto = jsonArray_photo.getJSONObject(i);
                String url = "https://farm"+flickrPhoto.getString("farm")+".staticflickr.com/"+flickrPhoto.get("server")+"/"+flickrPhoto.getString("id")+"_"+flickrPhoto.getString("secret")+".jpg";
                listOfURLs.add(url);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public static String QueryFlickr() {
        String qResult = null;
        //String qString = FlickrQuery_url + FlickrQuery_per_page + FlickrQuery_nojsoncallback + FlickrQuery_format + FlickrQuery_tag + q + FlickrQuery_key + FlickrApiKey;
        HttpURLConnection urlConnection;
        URL url;
        try {
            url = new URL("https://api.flickr.com/services/rest/?method=flickr.galleries.getPhotos&api_key=6419a7d651a892eb41276ecb4954e7ab&gallery_id=66911286-72157647277042064&format=json&nojsoncallback=1");
            urlConnection = (HttpURLConnection) url.openConnection();
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = urlConnection.getInputStream();
                Reader in = new InputStreamReader(inputStream);
                BufferedReader bufferedreader = new BufferedReader(in);
                StringBuilder stringBuilder = new StringBuilder();
                String stringReadLine = null;
                while ((stringReadLine = bufferedreader.readLine()) != null) {
                    stringBuilder.append(stringReadLine + "\n");
                }
                qResult = stringBuilder.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qResult;
    }
}
