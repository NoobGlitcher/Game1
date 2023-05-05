package com.example.wizzardcube.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.media.MediaPlayer;

import com.example.wizzardcube.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageButton mitem1, mitem2, mitem3, mitem4, mitem5, mitem6, mitem7, mitem8, mitem9, mchoisis, mune, mactivite, mCuisineConnexion, mTranchee, mColombe;
    private RadioButton mrb1, mrb2, mrb3, mrb4, mrb5, mrb6, mrb7, mrb8, mrb9, mrb10, mrb11, mrb12, mrb13, mrb14, mrb15, mrb16, mrb17, mrb18;

    private Integer ichoisis, iune, iactivite;

    private Button mPorte;

    private ImageView mFond;
    private Handler handler2, handler3;
    private MediaPlayer mediaPlayer, mediaPlayer2;
    private Runnable stopPlayerRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_main);

        mitem1 = findViewById(R.id.item1);
        mitem2 = findViewById(R.id.item2);
        mitem3 = findViewById(R.id.item3);
        mitem4 = findViewById(R.id.item4);
        mitem5 = findViewById(R.id.item5);
        mitem6 = findViewById(R.id.item6);
        mitem7 = findViewById(R.id.item7);
        mitem8 = findViewById(R.id.item8);
        mitem9 = findViewById(R.id.item9);

        mrb1 = findViewById(R.id.radioButton);
        mrb2 = findViewById(R.id.radioButton2);
        mrb3 = findViewById(R.id.radioButton3);
        mrb4 = findViewById(R.id.radioButton4);
        mrb5 = findViewById(R.id.radioButton5);
        mrb6 = findViewById(R.id.radioButton6);
        mrb7 = findViewById(R.id.radioButton7);
        mrb8 = findViewById(R.id.radioButton8);
        mrb9 = findViewById(R.id.radioButton9);

        mrb10 = findViewById(R.id.radioButton10);
        mrb11 = findViewById(R.id.radioButton11);
        mrb12 = findViewById(R.id.radioButton12);
        mrb13 = findViewById(R.id.radioButton13);
        mrb14 = findViewById(R.id.radioButton14);
        mrb15 = findViewById(R.id.radioButton15);
        mrb16 = findViewById(R.id.radioButton16);
        mrb17 = findViewById(R.id.radioButton17);
        mrb18 = findViewById(R.id.radioButton18);

        mchoisis = findViewById(R.id.choisis);
        mune = findViewById(R.id.une);
        mactivite = findViewById(R.id.activite);

        ichoisis = 0;
        iune = 0;
        iactivite =0;

        mTranchee = findViewById(R.id.CuisineConnexion2);

        mTranchee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
                finish();

            }
        });

        mColombe = findViewById(R.id.CuisineConnexion3);

        mColombe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
                finish();

            }
        });



        mCuisineConnexion = findViewById(R.id.CuisineConnexion);

        mCuisineConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity5.class);
                startActivity(intent);
                finish();

            }
        });



        mPorte = findViewById(R.id.ButtonPorte);

        mFond = findViewById(R.id.Fond);

        mediaPlayer = MediaPlayer.create(this, R.raw.sonporte);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.inventaire);

        mchoisis.setOnClickListener(view -> {
            mchoisis.setVisibility(View.INVISIBLE);
            ichoisis = 0;
            RadioButton[] radioButtons = {mrb1, mrb2, mrb3, mrb4, mrb5, mrb6, mrb7, mrb8, mrb9};
            for (int i = 0; i < radioButtons.length; i++) {
                if (!radioButtons[i].isSelected()) {
                    ImageView[] imageViews = {mitem1, mitem2, mitem3, mitem4, mitem5, mitem6, mitem7, mitem8, mitem9};
                    imageViews[i].setImageResource(R.drawable.key);
                    mchoisis.setImageResource(R.drawable.fondvierge);
                    inventaire();
                    radioButtons[i].setSelected(true);
                    ichoisis = i + 1;
                    break;
                }
            }
        });

        mune.setOnClickListener(view -> {
            mune.setVisibility(View.INVISIBLE);
            iune = 0;
            RadioButton[] radioButtons = {mrb1, mrb2, mrb3, mrb4, mrb5, mrb6, mrb7, mrb8, mrb9};
            for (int i = 0; i < radioButtons.length; i++) {
                if (!radioButtons[i].isSelected()) {
                    ImageView[] imageViews = {mitem1, mitem2, mitem3, mitem4, mitem5, mitem6, mitem7, mitem8, mitem9};
                    imageViews[i].setImageResource(R.drawable.une);
                    mune.setImageResource(R.drawable.fondvierge);
                    inventaire() ;
                    radioButtons[i].setSelected(true);
                    iune = i + 1;
                    break;
                }
            }
        });

        mactivite.setOnClickListener(view -> {
            mactivite.setVisibility(View.INVISIBLE);
            iactivite = 0;
            RadioButton[] radioButtons = {mrb1, mrb2, mrb3, mrb4, mrb5, mrb6, mrb7, mrb8, mrb9};
            for (int i = 0; i < radioButtons.length; i++) {
                if (!radioButtons[i].isSelected()) {
                    ImageView[] imageViews = {mitem1, mitem2, mitem3, mitem4, mitem5, mitem6, mitem7, mitem8, mitem9};
                    imageViews[i].setImageResource(R.drawable.key);
                    mactivite.setImageResource(R.drawable.fondvierge);
                    inventaire() ;
                    radioButtons[i].setSelected(true);
                    iactivite = i + 1;
                    break;
                }
            }
        });
        List<View> items = new ArrayList<>();
        items.add(mitem1);
        items.add(mitem2);
        items.add(mitem3);
        items.add(mitem4);
        items.add(mitem5);
        items.add(mitem6);
        items.add(mitem7);
        items.add(mitem8);
        items.add(mitem9);

        List<RadioButton> radioButtons = new ArrayList<>();
        radioButtons.add(mrb10);
        radioButtons.add(mrb11);
        radioButtons.add(mrb12);
        radioButtons.add(mrb13);
        radioButtons.add(mrb14);
        radioButtons.add(mrb15);
        radioButtons.add(mrb16);
        radioButtons.add(mrb17);
        radioButtons.add(mrb18);


        for (int i = 0; i < items.size(); i++) {
            final int index = i;
            items.get(i).setOnClickListener(view -> {
                for (int j = 0; j < radioButtons.size(); j++) {
                    if (j == index) {
                        radioButtons.get(j).setSelected(true);
                        GradientDrawable border = new GradientDrawable();
                        border.setStroke(4, Color.RED);
                        border.setCornerRadius(15);
                        items.get(j).setBackground(border);
                    } else {
                        radioButtons.get(j).setSelected(false);
                        GradientDrawable border = new GradientDrawable();
                        border.setStroke(2, Color.BLACK);
                        border.setCornerRadius(15);
                        items.get(j).setBackground(border);
                    }
                }
            });
        }


        mPorte.setOnClickListener(view -> {
            if (mrb10.isSelected()) {
                executeCommonCode(mrb10, 1);

            } else if (mrb11.isSelected()) {
                executeCommonCode(mrb11, 2);

            } else if (mrb12.isSelected()) {
                executeCommonCode(mrb12, 3);

            }else if (mrb13.isSelected()) {
                executeCommonCode(mrb13, 4);

            }else if (mrb14.isSelected()) {
                executeCommonCode(mrb14, 5);

            }else if (mrb15.isSelected()) {
                executeCommonCode(mrb15, 6);

            }else if (mrb16.isSelected()) {
                executeCommonCode(mrb16, 7);

            }else if (mrb17.isSelected()) {
                executeCommonCode(mrb17, 8);

            }else if (mrb18.isSelected()) {
                executeCommonCode(mrb18, 9);

            } else {}
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        if (handler2 != null) {
            handler2.removeCallbacks(stopPlayerRunnable);
        }
    }

    public void mitemvierge1() {

        mitem1.setImageResource(R.drawable.fondvierge);
        mrb1.setSelected(false);

    }

    public void mitemvierge2() {

        mitem2.setImageResource(R.drawable.fondvierge);
        mrb2.setSelected(false);
    }

    public void mitemvierge3() {

        mitem3.setImageResource(R.drawable.fondvierge);
        mrb3.setSelected(false);
    }

    public void mitemvierge4() {

        mitem4.setImageResource(R.drawable.fondvierge);
        mrb4.setSelected(false);
    }

    public void mitemvierge5() {

        mitem5.setImageResource(R.drawable.fondvierge);
        mrb5.setSelected(false);
    }

    public void mitemvierge6() {

        mitem6.setImageResource(R.drawable.fondvierge);
        mrb6.setSelected(false);

    }

    public void mitemvierge7() {

        mitem7.setImageResource(R.drawable.fondvierge);
        mrb7.setSelected(false);

    }

    public void mitemvierge8() {

        mitem8.setImageResource(R.drawable.fondvierge);
        mrb8.setSelected(false);

    }

    public void mitemvierge9() {

        mitem9.setImageResource(R.drawable.fondvierge);
        mrb9.setSelected(false);

    }

    public void OuverturePorte() {

        mFond.setImageResource(R.drawable.fondouvert);
    }

    @SuppressLint("NonConstantResourceId")
    private void executeCommonCode(RadioButton radioButton, int activityNumber) {
        if (ichoisis == activityNumber) {
            OuverturePorte();
            mediaPlayer.start();
            handler2 = new Handler();
            stopPlayerRunnable = () -> {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
            };
            handler2.postDelayed(stopPlayerRunnable, 8000); //6 secondes
            switch(radioButton.getId()) {
                case R.id.radioButton10:
                    mitemvierge1();
                    break;
                case R.id.radioButton11:
                    mitemvierge2();
                    break;
                case R.id.radioButton12:
                    mitemvierge3();
                    break;
                case R.id.radioButton13:
                    mitemvierge4();
                    break;
                case R.id.radioButton14:
                    mitemvierge5();
                    break;
                case R.id.radioButton15:
                    mitemvierge6();
                    break;
                case R.id.radioButton16:
                    mitemvierge7();
                    break;
                case R.id.radioButton17:
                    mitemvierge8();
                    break;
                case R.id.radioButton18:
                    mitemvierge9();
                    break;

            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent(getApplicationContext(), Prairie.class);
                    startActivity(intent);
                    finish();

                }
            }, 3000);
        } else{}
    }

    private void inventaire(){


        mediaPlayer2.start();
        handler3 = new Handler();
        stopPlayerRunnable = () -> {
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer2.stop();
            }
        };
        handler3.postDelayed(stopPlayerRunnable, 8000);


    }

}