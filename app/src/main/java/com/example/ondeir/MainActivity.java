package com.example.ondeir;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    ImageView image;
    TextView text;

    Animation aparece;
    Animation some;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.imgSiga);
        text = findViewById(R.id.txtTexto);

        text.setText("Toque para Continuar:");
        image.setVisibility(View.INVISIBLE);

        aparece = new AlphaAnimation(0,1);
        some = new AlphaAnimation(1,0);

        some.setDuration(500);
        aparece.setDuration(500);

        aparece.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                image.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                image.setVisibility(View.VISIBLE);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        some.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                image.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                image.setVisibility(View.INVISIBLE);
                text.setText("Toque para Continuar:");
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
    public void clicoutela(View view) {
        if (Math.random() < 0.5) {
            text.setText("Siga para Esquerda");
            image.setScaleX(1f);
        } else {
            text.setText("Siga para Direita");
            image.setScaleX(-1f);

        }

        image.startAnimation(aparece);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                image.startAnimation(some);

            }
        }, 2000);
    }
}
