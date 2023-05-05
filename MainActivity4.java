package com.example.wizzardcube.View;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.example.wizzardcube.R;

public class MainActivity4 extends AppCompatActivity {
    private int screenHeight;
    private ImageView piece;
    private Button Start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        piece = findViewById(R.id.imageView26);


        Start = findViewById(R.id.button2);

        Start.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

        // Récupération de la hauteur de l'écran
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenHeight = displayMetrics.heightPixels;

        // Lancement de l'animation
        startAnimation();

    }
});


            }

            private void startAnimation() {
                // Création de l'animation
                ObjectAnimator animation = ObjectAnimator.ofFloat(piece, "translationY", 0f, screenHeight);
                animation.setDuration(3000); // Durée de l'animation en millisecondes
                animation.setInterpolator(new AccelerateInterpolator()); // Accélération de l'animation

                // Définition de l'action à la fin de l'animation
                animation.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        piece.setVisibility(View.GONE); // Fait disparaître l'image view
                    }
                });

                // Lancement de l'animationanimation.start();
                animation.start();
    }
}





