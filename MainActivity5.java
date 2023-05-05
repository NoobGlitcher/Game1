package com.example.wizzardcube.View;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.wizzardcube.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {
    private ImageView mTranchee, mHerbe, mCiel, mHerbe2;
    private int screenHeight, screenWidth;
    private ImageButton mitem1, mitem2, mitem3, mitem4, mitem5, mitem6, mitem7, mitem8, mitem9,mTest, mRight, mLeft, mDown;
    private RadioButton mrb1, mrb2, mrb3, mrb4, mrb5, mrb6, mrb7, mrb8, mrb9, mrb10, mrb11, mrb12, mrb13, mrb14, mrb15, mrb16, mrb17, mrb18;





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main5);




        mTranchee= findViewById(R.id.tranchee);
        mHerbe= findViewById(R.id.Herbe);
        mCiel = findViewById(R.id.Ciel);
        mHerbe2 = findViewById(R.id.Herbe2);

        mTest = findViewById(R.id.TestTranchee);

        mitem1 = findViewById(R.id.item19);
        mitem2 = findViewById(R.id.item20);
        mitem3 = findViewById(R.id.item21);
        mitem4 = findViewById(R.id.item22);
        mitem5 = findViewById(R.id.item23);
        mitem6 = findViewById(R.id.item24);
        mitem7 = findViewById(R.id.item25);
        mitem8 = findViewById(R.id.item26);
        mitem9 = findViewById(R.id.item27);

        mrb1 = findViewById(R.id.radioButton37);
        mrb2 = findViewById(R.id.radioButton38);
        mrb3 = findViewById(R.id.radioButton39);
        mrb4 = findViewById(R.id.radioButton40);
        mrb5 = findViewById(R.id.radioButton41);
        mrb6 = findViewById(R.id.radioButton42);
        mrb7 = findViewById(R.id.radioButton43);
        mrb8 = findViewById(R.id.radioButton44);
        mrb9 = findViewById(R.id.radioButton45);

        mrb10 = findViewById(R.id.radioButton46);
        mrb11 = findViewById(R.id.radioButton47);
        mrb12 = findViewById(R.id.radioButton48);
        mrb13 = findViewById(R.id.radioButton49);
        mrb14 = findViewById(R.id.radioButton50);
        mrb15 = findViewById(R.id.radioButton51);
        mrb16 = findViewById(R.id.radioButton52);
        mrb17 = findViewById(R.id.radioButton53);
        mrb18 = findViewById(R.id.radioButton54);

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


        mRight = findViewById(R.id.RightButton);

        mRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity6.class);
                startActivity(intent);
                finish();
            }
        });

        mLeft = findViewById(R.id.LeftButton);

        mLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity7.class);
                startActivity(intent);
                finish();
            }
        });

        mDown = findViewById(R.id.DownButton);

        mDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity8.class);
                startActivity(intent);
                finish();

            }
        });





        mTest.setOnClickListener(view -> {

            mTest.setVisibility(View.INVISIBLE);



            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            screenHeight = displayMetrics.heightPixels;
            screenWidth = displayMetrics.widthPixels;



            // Lancement de l'animation
            startAnimation();

            new Handler().postDelayed(() -> {
                startAnimation2();
            }, 3000);

            new Handler().postDelayed(() -> {
            startAnimation3();
            }, 3000);


        });


    }


    private void startAnimation() {

        ObjectAnimator animation = ObjectAnimator.ofFloat(mTranchee, "translationX", 0f, -screenHeight);
        animation.setDuration(3000); // Durée de l'animation en millisecondes
        animation.setInterpolator(new AccelerateInterpolator()); // Accélération de l'animation

        // Définition de l'action à la fin de l'animation
        animation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mTranchee.setVisibility(View.GONE); // Fait disparaître l'image view
            }
        });
        // Démarrer l'animation
        animation.start();
    }


    private void startAnimation2() {

        ObjectAnimator animation = ObjectAnimator.ofFloat(mHerbe, "translationX", 0f, -screenHeight);
        animation.setDuration(4500); // Durée de l'animation en millisecondes

        // Définition de l'action à la fin de l'animation
        animation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mHerbe.setVisibility(View.GONE); // Fait disparaître l'image view
            }
        });
        // Démarrer l'animation
        animation.start();
    }

    private void startAnimation3() {
        ObjectAnimator animation = ObjectAnimator.ofFloat(mCiel, "translationX", screenWidth, 0f);
        animation.setDuration(3000); // Durée de l'animation en millisecondes

        // Définition de l'action à la fin de l'animation
        animation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mCiel.setVisibility(View.VISIBLE); // Fait apparaître l'image view
            }
        });

        // Démarrer l'animation
        animation.start();
    }


}