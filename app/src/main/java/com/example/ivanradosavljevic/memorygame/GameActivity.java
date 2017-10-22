package com.example.ivanradosavljevic.memorygame;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    TextView tv_p1;
    TextView tv_level;
    ImageView iv_11, iv_12, iv_13, iv_14, iv_21, iv_22, iv_23, iv_24, iv_31, iv_32, iv_33, iv_34;
    public List<ImageView> imageViewList = new ArrayList<>();
    public ArrayList<String> listOfURLS = new ArrayList<>();
    public ArrayList<Card> listOfCards = new ArrayList<>();
    int[] cardsArray = {101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206};
    int image101, image102, image103, image104, image105, image106, image201, image202, image203, image204, image205, image206;
    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    int playerPoints = 0;
    ProgressBar progressBar;
    int levelTime = 0;
    int level = 1;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //vidi kad treba da se pokrece task (zbor resume)
        new JSONOperation(GameActivity.this).execute();
        setContentView(R.layout.game);
        tv_p1 = (TextView) findViewById(R.id.tv_p1);
        tv_level = (TextView) findViewById(R.id.tv_level);
        iv_11 = (ImageView) findViewById(R.id.iv_11);
        imageViewList.add(iv_11);
        iv_12 = (ImageView) findViewById(R.id.iv_12);
        imageViewList.add(iv_12);
        iv_13 = (ImageView) findViewById(R.id.iv_13);
        imageViewList.add(iv_13);
        iv_14 = (ImageView) findViewById(R.id.iv_14);
        imageViewList.add(iv_14);
        iv_21 = (ImageView) findViewById(R.id.iv_21);
        imageViewList.add(iv_21);
        iv_22 = (ImageView) findViewById(R.id.iv_22);
        imageViewList.add(iv_22);
        iv_23 = (ImageView) findViewById(R.id.iv_23);
        imageViewList.add(iv_23);
        iv_24 = (ImageView) findViewById(R.id.iv_24);
        imageViewList.add(iv_24);
        iv_31 = (ImageView) findViewById(R.id.iv_31);
        imageViewList.add(iv_31);
        iv_32 = (ImageView) findViewById(R.id.iv_32);
        imageViewList.add(iv_32);
        iv_33 = (ImageView) findViewById(R.id.iv_33);
        imageViewList.add(iv_33);
        iv_34 = (ImageView) findViewById(R.id.iv_34);
        imageViewList.add(iv_34);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        // check for number of points
            playerPoints = getIntent().getIntExtra("playerPoints", 0);
            levelTime = getIntent().getIntExtra("levelTime", 30);
            level = getIntent().getIntExtra("level", 1);
            tv_p1.setText("P1: " + playerPoints);
            tv_level.setText("Level: "+level);
    }

    public List<ImageView> getListOfImageViews() {
        return imageViewList;
    }

    public ArrayList<String> getListOfURLS() {
        return listOfURLS;
    }

    public void setListOfURLS(ArrayList<String> listOfURLS) {
        this.listOfURLS = listOfURLS;
    }

    public ArrayList<Card> getListOfCards() {
        return listOfCards;
    }

    public void clickedImage(View v) {
        ImageView iv = (ImageView) findViewById(v.getId());
        int theCard = Integer.parseInt((String) v.getTag());
        doStaff(iv, theCard);
    }

    private void doStaff(ImageView iv, int card) {
        //run animation for front of the images
        iv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out));
        iv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));
        //set the correct image to the imageView
        switch (cardsArray[card]) {
            case 101:
                for (Card c : listOfCards) {
                    if (c.getId() == 101) {
                        iv.setImageBitmap(c.getBitmap());
                        break;
                    }
                }
                break;
            case 102:
                for (Card c : listOfCards) {
                    if (c.getId() == 102) {
                        iv.setImageBitmap(c.getBitmap());
                        break;
                    }
                }
                break;
            case 103:
                for (Card c : listOfCards) {
                    if (c.getId() == 103) {
                        iv.setImageBitmap(c.getBitmap());
                        break;
                    }
                }
                break;
            case 104:
                for (Card c : listOfCards) {
                    if (c.getId() == 104) {
                        iv.setImageBitmap(c.getBitmap());
                        break;
                    }
                }
                break;
            case 105:
                for (Card c : listOfCards) {
                    if (c.getId() == 105) {
                        iv.setImageBitmap(c.getBitmap());
                        break;
                    }
                }
                break;
            case 106:
                for (Card c : listOfCards) {
                    if (c.getId() == 106) {
                        iv.setImageBitmap(c.getBitmap());
                        break;
                    }
                }
                break;
            case 201:
                for (Card c : listOfCards) {
                    if (c.getId() == 101) {
                        iv.setImageBitmap(c.getBitmap());
                        break;
                    }
                }
                break;
            case 202:
                for (Card c : listOfCards) {
                    if (c.getId() == 102) {
                        iv.setImageBitmap(c.getBitmap());
                        break;
                    }
                }
                break;
            case 203:
                for (Card c : listOfCards) {
                    if (c.getId() == 103) {
                        iv.setImageBitmap(c.getBitmap());
                        break;
                    }
                }
                break;
            case 204:
                for (Card c : listOfCards) {
                    if (c.getId() == 104) {
                        iv.setImageBitmap(c.getBitmap());
                        break;
                    }
                }
                break;
            case 205:
                for (Card c : listOfCards) {
                    if (c.getId() == 105) {
                        iv.setImageBitmap(c.getBitmap());
                        break;
                    }
                }
                break;
            case 206:
                for (Card c : listOfCards) {
                    if (c.getId() == 106) {
                        iv.setImageBitmap(c.getBitmap());
                        break;
                    }
                }
        }
        //tv_p1.setText(playerPoints);
        //check which image is selected and save it to temporary variable
        if (cardNumber == 1) {
            firstCard = cardsArray[card];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;
            iv.setEnabled(false);
        } else if (cardNumber == 2) {
            secondCard = cardsArray[card];
            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;
            for (ImageView imageView : imageViewList) {
                imageView.setEnabled(false);
            }
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //check if the selected images are equal
                    calculate();
                }
            }, 1000);

        }
    }

    private void calculate() {
        //if images are equal remove themand add points
        if (firstCard == secondCard) {
            switch (clickedFirst) {
                case 0:
                    iv_11.setEnabled(false);
                    imageViewList.remove(iv_11);
                    break;
                case 1:
                    iv_12.setEnabled(false);
                    imageViewList.remove(iv_12);
                    break;
                case 2:
                    iv_13.setEnabled(false);
                    imageViewList.remove(iv_13);
                    break;
                case 3:
                    iv_14.setEnabled(false);
                    imageViewList.remove(iv_14);
                    break;
                case 4:
                    iv_21.setEnabled(false);
                    imageViewList.remove(iv_21);
                    break;
                case 5:
                    iv_22.setEnabled(false);
                    imageViewList.remove(iv_22);
                    break;
                case 6:
                    iv_23.setEnabled(false);
                    imageViewList.remove(iv_23);
                    break;
                case 7:
                    iv_24.setEnabled(false);
                    imageViewList.remove(iv_24);
                    break;
                case 8:
                    iv_31.setEnabled(false);
                    imageViewList.remove(iv_31);
                    break;
                case 9:
                    iv_32.setEnabled(false);
                    imageViewList.remove(iv_32);
                    break;
                case 10:
                    iv_33.setEnabled(false);
                    imageViewList.remove(iv_33);
                    break;
                case 11:
                    iv_34.setEnabled(false);
                    imageViewList.remove(iv_34);
                    break;
            }
            switch (clickedSecond) {
                case 0:
                    iv_11.setEnabled(false);
                    imageViewList.remove(iv_11);
                    break;
                case 1:
                    iv_12.setEnabled(false);
                    imageViewList.remove(iv_12);
                    break;
                case 2:
                    iv_13.setEnabled(false);
                    imageViewList.remove(iv_13);
                    break;
                case 3:
                    iv_14.setEnabled(false);
                    imageViewList.remove(iv_14);
                    break;
                case 4:
                    iv_21.setEnabled(false);
                    imageViewList.remove(iv_21);
                    break;
                case 5:
                    iv_22.setEnabled(false);
                    imageViewList.remove(iv_22);
                    break;
                case 6:
                    iv_23.setEnabled(false);
                    imageViewList.remove(iv_23);
                    break;
                case 7:
                    iv_24.setEnabled(false);
                    imageViewList.remove(iv_24);
                    break;
                case 8:
                    iv_31.setEnabled(false);
                    imageViewList.remove(iv_31);
                    break;
                case 9:
                    iv_32.setEnabled(false);
                    imageViewList.remove(iv_32);
                    break;
                case 10:
                    iv_33.setEnabled(false);
                    imageViewList.remove(iv_33);
                    break;
                case 11:
                    iv_34.setEnabled(false);
                    imageViewList.remove(iv_34);
                    break;
            }
            playerPoints++;
            tv_p1.setText("P1: " + playerPoints);
        } else {
            for (ImageView imageVies : imageViewList) {
                imageVies.setImageResource(R.drawable.ic_back);
            }
        }

        for (ImageView imageVies : imageViewList) {
            imageVies.setEnabled(true);
        }
        //check if the game is over
        checkEnd();
    }

    private void checkEnd() {
        if (imageViewList.size() == 0) {
            progressBar.setProgress(0);
            countDownTimer.cancel();
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GameActivity.this);
            alertDialogBuilder.setMessage("Next level! \nP1:" + playerPoints)
                    .setCancelable(false)
                    .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("playerPoints", playerPoints);
                            levelTime = levelTime - 10;
                            intent.putExtra("levelTime", levelTime);
                            level++;
                            intent.putExtra("level",level);
                            finish();
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            savePoints(playerPoints,true);
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    private void savePoints(int points, boolean isClosing) {
        Intent intent = new Intent(GameActivity.this, SafePointsActivity.class);
        intent.putExtra("points", points);
        intent.putExtra("isClosing", isClosing);
        startActivity(intent);
    }
    //    @Override
//    protected void onPause() {
//        super.onPause();
//        SharedPreferences sharedPreferences = getSharedPreferences("X", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("gameActivity", getClass().getName());
//        editor.commit();
//    }

    private class JSONOperation extends AsyncTask<Void, Void, ArrayList<String>> {
        GameActivity context;
        ProgressDialog progressDialog;

        public JSONOperation(GameActivity context) {
            this.context = context;
            progressDialog = new ProgressDialog(context);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setTitle("Please Wait");
            progressDialog.show();
        }

        @Override
        protected ArrayList<String> doInBackground(Void... params) {
            String searchResult = FlickrManager.QueryFlickr();
            FlickrManager.GenerateList(searchResult);
            ArrayList<String> jsonResult = FlickrManager.listOfURLs;
            context.setListOfURLS(jsonResult);
            int counter = 100;
            for (int i = 0; i < jsonResult.size(); i++) {
                //duplicates 2x6
                if (i < 6) {
                    HttpURLConnection urlConnection;
                    try {
                        URL url = new URL(jsonResult.get(i));
                        urlConnection = (HttpURLConnection) url.openConnection();
                        InputStream inputStream = urlConnection.getInputStream();
                        Bitmap image = BitmapFactory.decodeStream(inputStream);
                        counter++;
                        context.getListOfCards().add(new Card(image, counter));

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
            return jsonResult;
        }

        @Override
        protected void onPostExecute(ArrayList<String> strings) {
            super.onPostExecute(strings);
            context.image101 = context.getListOfCards().get(0).getId();
            context.image201 = context.getListOfCards().get(0).getId() + 100;
            context.image102 = context.getListOfCards().get(1).getId();
            context.image202 = context.getListOfCards().get(1).getId() + 100;
            context.image103 = context.getListOfCards().get(2).getId();
            context.image203 = context.getListOfCards().get(2).getId() + 100;
            context.image104 = context.getListOfCards().get(3).getId();
            context.image204 = context.getListOfCards().get(3).getId() + 100;
            context.image105 = context.getListOfCards().get(4).getId();
            context.image205 = context.getListOfCards().get(4).getId() + 100;
            context.image106 = context.getListOfCards().get(5).getId();
            context.image206 = context.getListOfCards().get(5).getId() + 100;
            Collections.shuffle(Arrays.asList(context.cardsArray));
            progressDialog.dismiss();
            countDownTimer = new CountDownTimer(levelTime * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    int progress = (int) (millisUntilFinished / 1000);
                    progressBar.setProgress(progress);
                }

                @Override
                public void onFinish() {
                    progressBar.setProgress(0);
                    if (getListOfImageViews().size() != 0) {
                        Toast.makeText(getApplicationContext(), "TIMES UP! Number of points: " + playerPoints, Toast.LENGTH_SHORT).show();
                    }
                    for (ImageView iv : getListOfImageViews()) {
                        iv.setEnabled(false);
                    }
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GameActivity.this);
                    alertDialogBuilder.setMessage("Try again? \nP1:" + playerPoints)
                            .setCancelable(false)
                            .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                                    finish();
                                    startActivity(intent);
                                    savePoints(playerPoints, false);
                                }
                            })
                            .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                    finish();
                                    savePoints(playerPoints, true);
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            }.start();
        }
    }
}
