package com.example.wizzardcube.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.wizzardcube.R;

import java.util.ArrayList;
import java.util.List;

public class Prairie extends AppCompatActivity {

    private ImageButton mitem10, mitem11, mitem12, mitem13, mitem14, mitem15, mitem16, mitem17, mitem18;
    private RadioButton mrb20, mrb21, mrb22, mrb23, mrb24, mrb25, mrb26, mrb27, mrb28, mrb29, mrb30, mrb31, mrb32, mrb33, mrb34, mrb35, mrb36, mrb19;
    private Button mButtonPrairie, mButtonTronc, mButtonFeuille;
    private ImageView mPrairie, mTronc, mChat;
    private Integer iFeuille;
    private MediaPlayer mediaPlayer2;
    private Handler handler3;
    private Runnable stopPlayerRunnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prairie);


        mitem10 = findViewById(R.id.item10);
        mitem11 = findViewById(R.id.item11);
        mitem12 = findViewById(R.id.item12);
        mitem13 = findViewById(R.id.item13);
        mitem14 = findViewById(R.id.item14);
        mitem15 = findViewById(R.id.item15);
        mitem16 = findViewById(R.id.item16);
        mitem17 = findViewById(R.id.item17);
        mitem18 = findViewById(R.id.item18);

        mrb19 = findViewById(R.id.radioButton19);
        mrb20 = findViewById(R.id.radioButton20);
        mrb21 = findViewById(R.id.radioButton21);
        mrb22 = findViewById(R.id.radioButton22);
        mrb23 = findViewById(R.id.radioButton23);
        mrb24 = findViewById(R.id.radioButton24);
        mrb25 = findViewById(R.id.radioButton25);
        mrb26 = findViewById(R.id.radioButton26);
        mrb27 = findViewById(R.id.radioButton27);

        mrb28 = findViewById(R.id.radioButton28);
        mrb29 = findViewById(R.id.radioButton29);
        mrb30 = findViewById(R.id.radioButton30);
        mrb31 = findViewById(R.id.radioButton31);
        mrb32 = findViewById(R.id.radioButton32);
        mrb33 = findViewById(R.id.radioButton33);
        mrb34 = findViewById(R.id.radioButton34);
        mrb35 = findViewById(R.id.radioButton35);
        mrb36 = findViewById(R.id.radioButton36);

        iFeuille=0;

        mediaPlayer2 = MediaPlayer.create(this, R.raw.inventaire);

        mPrairie = findViewById(R.id.Prairie);

        mButtonPrairie = findViewById(R.id.ButtonPrairie);
        mButtonTronc = findViewById(R.id.ButtonTronc);
        mButtonFeuille = findViewById(R.id.ButtonFeuille);

        mButtonFeuille.setVisibility(View.INVISIBLE);

        mButtonTronc.setVisibility(View.INVISIBLE);

        mChat = findViewById(R.id.Chat);
        mChat.setVisibility(View.INVISIBLE);

        mButtonPrairie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mPrairie.setImageResource(R.drawable.tronc);
                mButtonPrairie.setVisibility(View.INVISIBLE);
                mButtonTronc.setVisibility(View.VISIBLE);
                mButtonFeuille.setVisibility(View.VISIBLE);

            }
        });



        mButtonFeuille.setOnClickListener(view -> {
            mButtonFeuille.setVisibility(View.INVISIBLE);
            RadioButton[] radioButtons = {mrb19, mrb20, mrb21, mrb22, mrb23, mrb24, mrb25, mrb26, mrb27};
            for (int i = 0; i < radioButtons.length; i++) {
                if (!radioButtons[i].isSelected()) {
                    ImageView[] imageViews = {mitem10, mitem11, mitem12, mitem13, mitem14, mitem15, mitem16, mitem17, mitem18};
                    imageViews[i].setImageResource(R.drawable.feuille);
                    inventaire();
                    radioButtons[i].setSelected(true);
                    iFeuille = i + 1;
                    break;
                }
            }
        });

        List<View> items = new ArrayList<>();
        items.add(mitem10);
        items.add(mitem11);
        items.add(mitem12);
        items.add(mitem13);
        items.add(mitem14);
        items.add(mitem15);
        items.add(mitem16);
        items.add(mitem17);
        items.add(mitem18);

        List<RadioButton> radioButtons = new ArrayList<>();
        radioButtons.add(mrb28);
        radioButtons.add(mrb29);
        radioButtons.add(mrb30);
        radioButtons.add(mrb31);
        radioButtons.add(mrb32);
        radioButtons.add(mrb33);
        radioButtons.add(mrb34);
        radioButtons.add(mrb35);
        radioButtons.add(mrb36);

        for (int i = 0; i < items.size(); i++) {
            final int index = i;
            items.get(i).setOnClickListener(view -> {
                for (int j = 0; j < radioButtons.size(); j++) {
                    if (j == index) {
                        radioButtons.get(j).setSelected(true);
                        GradientDrawable border = new GradientDrawable();
                        border.setStroke(4, Color.RED);
                        border.setCornerRadius(1);
                        items.get(j).setBackground(border);
                    } else {
                        radioButtons.get(j).setSelected(false);
                        GradientDrawable border = new GradientDrawable();
                        border.setStroke(2, Color.BLACK);
                        border.setCornerRadius(1);
                        items.get(j).setBackground(border);
                    }
                }
            });
        }

        mButtonTronc.setOnClickListener(view -> {
            mChat.setVisibility(View.VISIBLE);

            if (mrb28.isSelected()) {
                executeCommonCode(mrb28, 1);

            } else if (mrb29.isSelected()) {
                executeCommonCode(mrb29, 2);

            } else if (mrb30.isSelected()) {
                executeCommonCode(mrb30, 3);

            }else if (mrb31.isSelected()) {
                executeCommonCode(mrb31, 4);

            }else if (mrb32.isSelected()) {
                executeCommonCode(mrb32, 5);

            }else if (mrb33.isSelected()) {
                executeCommonCode(mrb33, 6);

            }else if (mrb34.isSelected()) {
                executeCommonCode(mrb34, 7);

            }else if (mrb35.isSelected()) {
                executeCommonCode(mrb35, 8);

            }else if (mrb36.isSelected()) {
                executeCommonCode(mrb36, 8);

            }
        });



    }





    public void mitemvierge1() {

        mitem10.setImageResource(R.drawable.fondvierge);
        mrb19.setSelected(false);


    }

    public void mitemvierge2() {

        mitem11.setImageResource(R.drawable.fondvierge);
        mrb20.setSelected(false);

    }

    public void mitemvierge3() {

        mitem12.setImageResource(R.drawable.fondvierge);
        mrb21.setSelected(false);


    }

    public void mitemvierge4() {

        mitem13.setImageResource(R.drawable.fondvierge);
        mrb22.setSelected(false);


    }

    public void mitemvierge5() {

        mitem14.setImageResource(R.drawable.fondvierge);
        mrb23.setSelected(false);


    }

    public void mitemvierge6() {

        mitem15.setImageResource(R.drawable.fondvierge);
        mrb24.setSelected(false);

    }

    public void mitemvierge7() {

        mitem16.setImageResource(R.drawable.fondvierge);
        mrb25.setSelected(false);


    }

    public void mitemvierge8() {

        mitem17.setImageResource(R.drawable.fondvierge);
        mrb26.setSelected(false);


    }

    public void mitemvierge9() {

        mitem18.setImageResource(R.drawable.fondvierge);
        mrb27.setSelected(false);


    }




    @SuppressLint("NonConstantResourceId")
    private void executeCommonCode(RadioButton radioButton, int activityNumber) {
        if (iFeuille == activityNumber) {
            mChat.setVisibility(View.VISIBLE);
            mChat.setImageResource(R.drawable.chat2);

            switch(radioButton.getId()) {
                case R.id.radioButton28:
                    mitemvierge1();
                    break;
                case R.id.radioButton29:
                    mitemvierge2();
                    break;
                case R.id.radioButton30:
                    mitemvierge3();
                    break;
                case R.id.radioButton31:
                    mitemvierge4();
                    break;
                case R.id.radioButton32:
                    mitemvierge5();
                    break;
                case R.id.radioButton33:
                    mitemvierge6();
                    break;
                case R.id.radioButton34:
                    mitemvierge7();
                    break;
                case R.id.radioButton35:
                    mitemvierge8();
                    break;
                case R.id.radioButton36:
                    mitemvierge9();
                    break;

            }

        } else {}
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
